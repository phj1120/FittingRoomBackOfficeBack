package org.plateer.fittingroombo.product.mapper;

import org.plateer.fittingroombo.product.dto.ProductCategoryDTO;

/**
 * 카테고리 관리
 * 작성자: 이수영, 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
public interface CategoryMapper {

    ProductCategoryDTO getProductCategory(Long prcNo);
    void insertProductCategory(ProductCategoryDTO productCategoryDTO);
}
