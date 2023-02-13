package org.plateer.fittingroombo.product.mapper;

import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;

import java.util.List;

public interface ProductMapper {

    // 상품 조회
    ProductDTO getProduct(Long prNo); // 상품 번호

    // 목록 조회
    List<ProductDTO> getProductList(Long sNo, ProductPageSearchRequestDTO productPageSearchRequestDTO); // 판매자 번호

    // 상품 추가
    int insertProduct(ProductDTO productDTO); // 상품

    // 상품 삭제
    int deleteProduct(Long prNo); // 상품 번호

    // 상품 수정
    int updateProduct(ProductDTO productDTO); // 상품
}
