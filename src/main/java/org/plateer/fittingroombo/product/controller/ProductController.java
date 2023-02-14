package org.plateer.fittingroombo.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.util.ImageUtil;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductFileDTO;
import org.plateer.fittingroombo.product.dto.ProductInsertDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<ProductDTO> productDTO(Long seNo, ProductPageSearchRequestDTO productPageSearchRequestDTO) {
        return productService.getProductList(seNo, productPageSearchRequestDTO);

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
    public ResultDTO<Long> insertProduct(ProductInsertDTO productInsertDTO) {
        // 이미지 저장
        List<ProductFileDTO> images = imageUtil.saveImages(productInsertDTO);

        // 상품 저장
        ProductDTO productDTO = new ProductDTO(productInsertDTO, images);
        Long result = productService.insertProduct(productDTO);

        return ResultDTO.<Long>builder().data(result).build();
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
    public ResultDTO<Long> updateProduct(@PathVariable Long id, ProductInsertDTO productInsertDTO) {
        // 이전 파일 삭제
        productService.deleteProductFile(id);

        // 이미지 저장
        List<ProductFileDTO> images = imageUtil.saveImages(productInsertDTO);
        ProductDTO productDTO = new ProductDTO(productInsertDTO, images);
        productDTO.setPrNo(id);

        // 상품 수정
        Long result = productService.updateProduct(productDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }
}
