package org.plateer.fittingroombo.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public ProductDTO getProduct(Long prNo) {
        ProductDTO productDTO = productMapper.getProduct(prNo);
        // TODO 썸네일, 카테고리 Join 으로 가져오고
        //  file, 판매 상품 조회 해서 set 하기

        return productDTO;
    }


    public List<ProductDTO> getProductList(Long sNo, ProductPageSearchRequestDTO productPageSearchRequestDTO) {
        return productMapper.getProductList(sNo, productPageSearchRequestDTO);
    }
}
