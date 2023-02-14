package org.plateer.fittingroombo.product.mapper;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductFileDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.dto.SellProductDTO;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;
import org.plateer.fittingroombo.product.dto.enums.ProductSearchType;
import org.plateer.fittingroombo.product.dto.enums.SellProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
        SellProductDTO sellProductDTO = new SellProductDTO(1L, "100", SellProductStatus.ACTIVE);

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
        sellProductDTO.setSpStatus(SellProductStatus.INACTIVE);
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
        int i = productMapper.deleteSellProduct(sellProductDTO.getSpNo());

        System.out.println(sellProductDTO);

        System.out.println(productMapper.getSellProductList(prNo).size());
    }

    @Test
    void selectFiles() {
        List<ProductFileDTO> productFileDTOS = productMapper.selectFiles(ProductFileType.BOTTOM, 67L);
        List<ProductFileDTO> productFileDTOS1 = productMapper.selectFiles(ProductFileType.TOP, 67L);

        System.out.println();
    }
}