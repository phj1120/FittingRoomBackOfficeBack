package org.plateer.fittingroombo.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInsertDTO {

    private String prBrand; // 브랜드

    private String prName; // 상품명

    private Long prPrice; // 가격

    private ProductStatus prStatus;

    private LocalDateTime prCreateDt; // 생성일

    private Long prcNo; // 카테고리 번호

    private Long seNo;

    private Integer thumbnailIndex; // 대표사진 인덱스

    private List<MultipartFile> topFiles = new ArrayList<>(); // 이미지
    private List<MultipartFile> bottomFiles = new ArrayList<>(); // 이미지

}
