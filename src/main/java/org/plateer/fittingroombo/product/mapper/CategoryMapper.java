package org.plateer.fittingroombo.product.mapper;

import org.plateer.fittingroombo.product.dto.ProductCategoryDTO;

public interface CategoryMapper {

    ProductCategoryDTO getProductCategory(Long prcNo);
    void insertProductCategory(ProductCategoryDTO productCategoryDTO);
}
