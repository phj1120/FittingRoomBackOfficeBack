package org.plateer.fittingroombo.product.mapper;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductFileDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.dto.SellProductDTO;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;
import org.plateer.fittingroombo.product.dto.enums.ProductSearchType;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * 상품 관리 Mapper 테스트
 * 작성자: 이수영, 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@SpringBootTest
@Transactional
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void getProduct() {
        ProductDTO productDTO = productMapper.getProduct(1L);

        System.out.println(productDTO);
    }

    @Test
    void getProductList() {
        ProductPageSearchRequestDTO productPageSearchRequestDTO = new ProductPageSearchRequestDTO(1, 10, List.of(ProductSearchType.NO), "1");

        List<ProductDTO> productList = productMapper.getProductList(1L, productPageSearchRequestDTO);

        System.out.println(productList);
    }

    @Test
    @Rollback
    void insertProduct() {
        ProductDTO productDTO = ProductDTO.builder()
                .prName("오바사이즈 맨투맨 블루")
                .prBrand("드로우핏")
                .prPrice(50000L)
                .prcNo(1L) // 카테고리 번호
                .seNo(1L) // 판매자 번호
                .build();

        productMapper.insertProduct(productDTO);
        System.out.println(productDTO);
    }

    @Test
    @Rollback
    void deleteProduct() {
        Long prNo = 19L;
        ProductStatus prStatus = ProductStatus.ACTIVE;
        ProductDTO beforeDelete = productMapper.getProduct(prNo);
        System.out.println(beforeDelete);

        productMapper.deleteProduct(prNo);

        ProductDTO afterDelete = productMapper.getProduct(prNo);
        System.out.println(afterDelete);
    }

    @Test
    @Rollback
    void updateProduct() {
        Long prNo = 22L;
        ProductDTO productDTO = productMapper.getProduct(prNo);
        ProductDTO beforeProductDTO = productMapper.getProduct(prNo);

        productDTO.setPrBrand(productDTO.getPrBrand() + LocalDateTime.now());
        productDTO.setPrName(productDTO.getPrName() + LocalDateTime.now());
        productDTO.setPrModifyDt(productDTO.getPrModifyDt() != null ? productDTO.getPrModifyDt().plusDays(1L) : LocalDateTime.now());

        productMapper.updateProduct(productDTO);

        ProductDTO afterProductDTO = productMapper.getProduct(prNo);

        System.out.println(afterProductDTO);
    }


    @Test
    @Rollback
    void insertSellProduct() {
        SellProductDTO sellProductDTO = new SellProductDTO(1L, "100", ProductStatus.ACTIVE);

        productMapper.insertSellProduct(sellProductDTO);

        System.out.println(sellProductDTO);
    }

    @Test
    void getSellProductList() {
        Long prNo = 1L;
        List<SellProductDTO> sellProductList = productMapper.getSellProductList(prNo);

        System.out.println(sellProductList);
    }

    @Test
    @Rollback
    void updateSellProduct() {
        Long prNo = 1L;
        List<SellProductDTO> sellProductList = productMapper.getSellProductList(prNo);

        SellProductDTO sellProductDTO = sellProductList.get(0);
        sellProductDTO.setSpSize(sellProductDTO.getSpSize() + LocalDateTime.now());
        sellProductDTO.setSpStatus(ProductStatus.INACTIVE);
        productMapper.updateSellProduct(sellProductDTO);

        System.out.println(sellProductDTO);
    }

    @Test
    @Rollback
    void deleteSellProduct() {
        Long prNo = 1L;
        List<SellProductDTO> sellProductList = productMapper.getSellProductList(prNo);
        System.out.println(sellProductList.size());

        SellProductDTO sellProductDTO = sellProductList.get(0);
        int i = productMapper.deleteSellProductBySpNo(sellProductDTO.getSpNo());

        System.out.println(sellProductDTO);

        System.out.println(productMapper.getSellProductList(prNo).size());
    }

    @Test
    void getFiles() {
        List<ProductFileDTO> productFileDTOS = productMapper.getProductFileList(67L);

        System.out.println(productFileDTOS);
    }

    @Test
    @Rollback
    void insertProductFiles() {
        List<ProductFileDTO> productFileDTOList = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(i -> {
            productFileDTOList.add(new ProductFileDTO("prfName" + i, UUID.randomUUID().toString(), ProductFileType.BOTTOM, 67L));

        });
        IntStream.rangeClosed(1, 5).forEach(i -> {
            productFileDTOList.add(new ProductFileDTO("prfName" + i, UUID.randomUUID().toString(), ProductFileType.TOP, 67L));
        });

        productMapper.insertProductFiles(productFileDTOList);

        List<ProductFileDTO> productFileList = productMapper.getProductFileList(67L);

        System.out.println(productFileList);
    }
}