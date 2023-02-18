package org.plateer.fittingroombo.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.product.dto.*;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;
import org.plateer.fittingroombo.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 상품 관리 Service
 * 작성자: 이수영, 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public ProductDTO getProduct(Long prNo) {
        // 상품 조회
        ProductDTO productDTO = productMapper.getProduct(prNo);
        if (Objects.isNull(productDTO)) {
            throw new IllegalArgumentException("존재하지 않는 상품");
        }

        // 파일 조회
        List<ProductFileDTO> productFileList = productMapper.getProductFileList(prNo);
        productDTO.setFiles(productFileList);

        // 판매 상품 조회
        List<SellProductDTO> sellProductList = productMapper.getSellProductList(prNo);
        productDTO.setOptions(sellProductList);

        return productDTO;
    }

    public PageResultDTO<ProductDTO> getProductList(Long seNo, ProductPageSearchRequestDTO productPageSearchRequestDTO) {
        List<ProductDTO> productList = productMapper.getProductList(seNo, productPageSearchRequestDTO);
        int total = productMapper.getProductListCount(seNo, productPageSearchRequestDTO);
        PageResultDTO<ProductDTO> result = PageResultDTO.<ProductDTO>withAll().pageRequestDTO(productPageSearchRequestDTO)
                .dtoList(productList)
                .total(total)
                .build();

        return result;
    }

    /**
     * 상품 추가
     **/
    public Long insertProduct(ProductDTO productDTO) {
        // product 추가
        productMapper.insertProduct(productDTO);

        // images 추가
        // TOP
        productDTO.getTopFiles().stream().forEach(productFileDTO -> {
            productFileDTO.setPrNo(productDTO.getPrNo());
            productMapper.insertProductTopFile(productFileDTO);
        });
        // BOTTOM
        productDTO.getBottomFiles().stream().forEach(productFileDTO -> {
            productFileDTO.setPrNo(productDTO.getPrNo());
            productMapper.insertProductBottomFile(productFileDTO);
        });

        return productDTO.getPrNo();
    }

    /**
     * 상품 수정
     **/
    public Long updateProduct(ProductDTO productDTO) {
        // 새로운 파일 추가
        productDTO.getTopFiles().stream().forEach(productFileDTO -> {
            productFileDTO.setPrNo(productDTO.getPrNo());
            productMapper.insertProductTopFile(productFileDTO);
        }); // TOP
        productDTO.getBottomFiles().stream().forEach(productFileDTO -> {
            productFileDTO.setPrNo(productDTO.getPrNo());
            productMapper.insertProductBottomFile(productFileDTO);
        }); // BOTTOM

        // product 수정
        productMapper.updateProduct(productDTO);

        return productDTO.getPrNo();
    }


    /**
     * 상품 삭제
     **/
    public Long deleteProduct(Long prNo) {
        productMapper.deleteProduct(prNo);

        // 판매 상품 삭제
        productMapper.deleteSellProductByPrNo(prNo);

        return prNo;
    }

    /**
     * 상품 상태 일괄 변경
     **/
    public List<Long> updateProductStatusAtOnce(UpdateProductStatusRequestDTO updateProductStatusRequestDTO) {
        ProductStatus prStatus = updateProductStatusRequestDTO.getPrStatus();
        List<Long> prNos = updateProductStatusRequestDTO.getPrNos();

        productMapper.updateProductStatusAtOnce(updateProductStatusRequestDTO);
        if (prStatus == ProductStatus.DELETE) {
            productMapper.deleteProductFileAtOnce(prNos);
        }

        return prNos;
    }

    public Long deleteProductFile(Long prNo) {
        productMapper.deleteProductFile(prNo);

        return prNo;
    }

    public List<SellProductDTO> getSellerProduct(Long prNo) {
        List<SellProductDTO> sellProductList = productMapper.getSellProductList(prNo);

        return sellProductList;
    }


    public Long insertSellProduct(SellProductDTO sellProductDTO) {
        productMapper.insertSellProduct(sellProductDTO);

        return sellProductDTO.getSpNo();
    }

    public Long deleteSellProduct(Long spNo) {
        productMapper.deleteSellProductBySpNo(spNo);

        return spNo;
    }

    public Long updateSellProduct(SellProductDTO sellProductDTO) {
        productMapper.updateSellProduct(sellProductDTO);

        return sellProductDTO.getSpNo();
    }

    public List<ProductCategoryDTO> getProductCategoryList() {
        return productMapper.getProductCategoryList();
    }

}
