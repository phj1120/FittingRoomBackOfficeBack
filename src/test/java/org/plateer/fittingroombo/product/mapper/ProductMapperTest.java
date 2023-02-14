package org.plateer.fittingroombo.product.mapper;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.dto.enums.ProductSearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
//@Transactional
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
        ProductPageSearchRequestDTO productPageSearchRequestDTO = ProductPageSearchRequestDTO.builder()
                .page(1)
                .size(10)
                .keyword("1")
                .types(List.of(ProductSearchType.NO))
                .build();

        List<ProductDTO> productList = productMapper.getProductList(1L, productPageSearchRequestDTO);

        System.out.println(productList);
    }

    @Test
    @Rollback
//    @Rollback(value = false)
    void insertProduct() {
        ProductDTO productDTO = ProductDTO.builder()
                .prName("오바사이즈 맨투맨 블루")
                .prBrand("드로우핏")
                .prPrice(50000L)
                .prcNo(1L) // 카테고리 번호
                .sNo(1L) // 판매자 번호
                .build();

        productMapper.insertProduct(productDTO);
        System.out.println(productDTO);
    }

    @Test
    @Rollback
    void deleteProduct() {
        Long prNo = 19L;
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

        productDTO.setPrBrand(productDTO.getPrBrand() + LocalDate.now());
        productDTO.setPrName(productDTO.getPrName() + LocalDate.now());
        productDTO.setPrModifyDt(productDTO.getPrModifyDt() != null ? productDTO.getPrModifyDt().plusDays(1L) : LocalDate.now());

        productMapper.updateProduct(productDTO);

        ProductDTO afterProductDTO = productMapper.getProduct(prNo);

        System.out.println(afterProductDTO);
    }
}