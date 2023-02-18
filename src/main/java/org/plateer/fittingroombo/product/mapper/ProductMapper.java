package org.plateer.fittingroombo.product.mapper;

import org.plateer.fittingroombo.product.dto.*;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;

import java.util.List;

/**
 * 상품 관리 Mapper
 * 작성자: 이수영, 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
public interface ProductMapper {
    // 상품
    int insertProduct(ProductDTO productDTO);

    ProductDTO getProduct(Long prNo);

    List<ProductDTO> getProductList(Long seNo, ProductPageSearchRequestDTO productPageSearchRequestDTO); // 판매자 번호

    int getProductListCount(Long seNo, ProductPageSearchRequestDTO productPageSearchRequestDTO);

    int updateProduct(ProductDTO productDTO);

    int deleteProduct(Long prNo);

    int updateProductStatusAtOnce(UpdateProductStatusRequestDTO updateProductStatusRequestDTO); // 상품 상태 일괄 변경

    // 판매 상품
    int insertSellProduct(SellProductDTO sellProductDTO);

    List<SellProductDTO> getSellProductList(Long prNo); // 상품 번호

    int updateSellProduct(SellProductDTO sellProductDTO);

    int deleteSellProductBySpNo(Long spNo);

    int deleteSellProductByPrNo(Long prNo);

    // 상품 사진
    int insertProductFiles(List<ProductFileDTO> productFileDTOList);
    int insertProductTopFile(ProductFileDTO productFileDTO);

    int insertProductBottomFile(ProductFileDTO productFileDTO);

    List<ProductFileDTO> getProductFileList(Long prNo); // 상품 번호

    int deleteProductFile(Long prNo); // 상품 번호

    int deleteProductFileAtOnce(List<Long> prNos); // 상품 번호

    List<ProductCategoryDTO> getProductCategoryList();
}
