package org.plateer.fittingroombo.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageRequestDTO;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/seller")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("product/list")
    // PageRequsetDTO, startDt, endDt, s_no, sort
    public List<ProductDTO> productDTO(PageRequestDTO pageRequestDTO) {
        return productService.getProductList(1L);
    }

}
