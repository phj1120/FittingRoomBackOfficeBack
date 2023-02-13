package org.plateer.fittingroombo.product.mapper;

import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class CategoryMapperTest {

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void getProductCategoryByNull() {
        ProductCategoryDTO productCategory = categoryMapper.getProductCategory(null);

        System.out.println(productCategory);
    }

    @Test
    void getProductCategoryByNotNull() {
        ProductCategoryDTO productCategory = categoryMapper.getProductCategory(3L);

        System.out.println(productCategory);
    }

    @Test
    @Rollback
    void insertProductCategory() {
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO("상품", 2, 3, 1L);
        categoryMapper.insertProductCategory(productCategoryDTO);
        System.out.println(productCategoryDTO);

        ProductCategoryDTO productCategory = categoryMapper.getProductCategory(productCategoryDTO.getPrcNo());
        System.out.println(productCategory);
    }
}