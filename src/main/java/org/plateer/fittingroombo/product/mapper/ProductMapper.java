package org.plateer.fittingroombo.product.mapper;

import org.plateer.fittingroombo.product.dto.*;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;

import java.util.List;

public interface ProductMapper {
    // 상품
    int insertProduct(ProductDTO productDTO);

    ProductDTO getProduct(Long prNo);

    List<ProductDTO> getProductList(Long seNo, ProductPageSearchRequestDTO productPageSearchRequestDTO); // 판매자 번호

    int getProductListCount(Long seNo, ProductPageSearchRequestDTO productPageSearchRequestDTO);

    int updateProduct(ProductDTO productDTO);

    int deleteProduct(Long prNo);

    // 판매 상품
    int insertSellProduct(SellProductDTO sellProductDTO);

    List<SellProductDTO> getSellProductList(Long prNo); // 상품 번호

    int updateSellProduct(SellProductDTO sellProductDTO);

    int deleteSellProduct(Long sprNo);

    // 상품 사진
    int insertProductTopFile(ProductFileDTO productFileDTO);

    int insertProductBottomFile(ProductFileDTO productFileDTO);

    List<ProductFileDTO> getProductFileList(Long prNo); // 상품 번호

    int deleteProductFile(Long prfNo); // 상품 번호

    List<ProductFileDTO> selectFiles(ProductFileType productFileType, Long prNo);

    List<ProductCategoryDTO> getProductCategoryList();
}
