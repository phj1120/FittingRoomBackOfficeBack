package org.plateer.fittingroombo.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.util.ImageUtil;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductFileDTO;
import org.plateer.fittingroombo.product.dto.ProductInsertDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/seller")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ImageUtil imageUtil;

    // TODO sort 보류
    @GetMapping("/product/list")
    // PageRequsetDTO, startDt, endDt, s_no, sort
    public List<ProductDTO> productDTO(Long sno, ProductPageSearchRequestDTO productPageSearchRequestDTO) {
        return productService.getProductList(sno, productPageSearchRequestDTO);

    }

    /**
     * 상세 조회
     **/
    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }
    
    /**
     * 상품 추가
     **/
    @PostMapping("/product")
    public Map<String,Long> insertProduct(ProductInsertDTO productInsertDTO) {

        List<ProductFileDTO> images = imageUtil.saveImages(productInsertDTO);

        ProductDTO productDTO = new ProductDTO(productInsertDTO, images);

        Long result = productService.insertProduct(productDTO);

        return Map.of("result", result);
    }

    /**
     * 상품 삭제
     **/
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

    /**
     * 상품 수정
     **/
    @PutMapping("/product/{id}")
    public Map<String,Long> updateProduct(@PathVariable Long id, ProductInsertDTO productInsertDTO) {

        List<ProductFileDTO> images = imageUtil.saveImages(productInsertDTO);

        ProductDTO productDTO = new ProductDTO(productInsertDTO, images);

        productDTO.setPrNo(id);

        Long result = productService.updateProduct(productDTO);

        return Map.of("result", result);
    }
}
