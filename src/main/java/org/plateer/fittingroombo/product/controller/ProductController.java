package org.plateer.fittingroombo.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/seller")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // TODO sort 보류
    @GetMapping("/product/list")
    // PageRequsetDTO, startDt, endDt, s_no, sort
    public List<ProductDTO> productDTO(Long sno, ProductPageSearchRequestDTO productPageSearchRequestDTO) {
        return productService.getProductList(sno, productPageSearchRequestDTO);

    }

    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }
}
