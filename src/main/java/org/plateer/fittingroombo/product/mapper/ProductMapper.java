package org.plateer.fittingroombo.product.mapper;

import org.plateer.fittingroombo.product.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
    //    ProductDTO getProductList(PageRequestDTO pageRequestDTO);
    List<ProductDTO> getProductList();

    ProductDTO getProduct(Long id);

}
