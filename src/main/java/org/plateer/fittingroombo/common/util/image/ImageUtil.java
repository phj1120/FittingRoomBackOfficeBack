package org.plateer.fittingroombo.common.util.image;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.plateer.fittingroombo.product.dto.ProductFileDTO;
import org.plateer.fittingroombo.product.dto.ProductInsertDTO;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 이미지 처리 공통 기능
 * 작성자: 이수영
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Log4j2
@Component
public class ImageUtil {

    @Value("${basePath}")
    private String basePath;

    // 이미지 경로에 해당하는 이미지 조회
    public Resource readImage(String storedName) {
        String imagePath = basePath + "/" + storedName;
        try {
            FileSystemResource file = new FileSystemResource(imagePath);
            log.info("[Read] : {}", storedName);

            return file;
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("[존재하지 않는 파일]: " + imagePath);
        }
    }

    // 이미지 저장 후 저장 결과 반환 - TOP
    public List<ProductFileDTO> saveTopImages(ProductInsertDTO productInsertDTO) {
        List<MultipartFile> topFiles = productInsertDTO.getTopFiles();

        Integer thumbnailIndex = productInsertDTO.getThumbnailIndex();

        initFolder();   // 폴더가 없다면 생성

        List<ProductFileDTO> productFiles = new ArrayList<>();

        for (int i = 0; i < topFiles.size(); i++) {
            MultipartFile file = topFiles.get(i);
            try {
                ProductFileDTO productFileDTO = saveImage(file);
                productFileDTO.setPrfType(ProductFileType.TOP);

                productFiles.add(productFileDTO);
            } catch (IllegalArgumentException e) {
                log.info("error");
            }
        }
        productFiles.get(thumbnailIndex).setPrfStatus(true);

        return productFiles;
    }

//    이미지 저장 후 저장 결과 반환 - BOTTOM
    public List<ProductFileDTO> saveBottomImages(ProductInsertDTO productInsertDTO) {
        List<MultipartFile> bottomFiles = productInsertDTO.getBottomFiles();

        initFolder();   // 폴더가 없다면 생성

        List<ProductFileDTO> productFiles = new ArrayList<>();

        for (int i = 0; i < bottomFiles.size(); i++) {
            MultipartFile file = bottomFiles.get(i);
            try {
                ProductFileDTO productFileDTO = saveImage(file);
                productFileDTO.setPrfType(ProductFileType.BOTTOM);

                productFiles.add(productFileDTO);
            } catch (IllegalArgumentException e) {
                log.info("error");
            }
        }

        return productFiles;
    }

    // 이미지 저장 후 저장 된 이름 반환
    private ProductFileDTO saveImage(MultipartFile file) {
        validImage(file);   // 이미지 파일이 아니면 에러처리

        // UUID 생성
        String uuid = generateStoredName(file);
        log.info("uuid : " + uuid);

        try {
            String imagePath = basePath + "/" + uuid;

            FileSystemResource resource = new FileSystemResource(imagePath);
            resource.getOutputStream().write(file.getBytes());

            // 썸네일 사이즈 조절 및 생성
            Thumbnails.of(new File(imagePath))
                    .forceSize(160, 160)
                    .toFile(new File(basePath + "/s_" + uuid));

            log.info("[Save] : {} -> {}", file.getOriginalFilename(), uuid);

            return new ProductFileDTO(file.getOriginalFilename(), uuid);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 저장 실패");
        }
    }

    private void initFolder() {
        File folder = new File(basePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    private void validImage(MultipartFile file) {
        if (!isImage(file)) {
            throw new IllegalArgumentException("이미지 파일 아님");
        }
    }

    private boolean isImage(MultipartFile file) {
        String contentType = file.getContentType();

        return contentType != null && contentType.startsWith("image/");
    }

    private String generateStoredName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String[] data = originalFilename.split("[.]");
        String extension = data[data.length - 1];
        String storedName = UUID.randomUUID() + "." + extension;

        return storedName;
    }

}
