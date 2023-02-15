package org.plateer.fittingroombo.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductFileDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.dto.SellProductDTO;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;
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

        List<ProductFileDTO> productTopFiles = productMapper.selectFiles(ProductFileType.TOP, prNo);
        productDTO.setTopFiles(productTopFiles);

        List<ProductFileDTO> productBottomFiles = productMapper.selectFiles(ProductFileType.BOTTOM, prNo);
        productDTO.setBottomFiles(productBottomFiles);

        return productDTO;
    }

    // TODO 페이징 결과 추가
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
     * 상품 상태 변경
     **/
    public Long updateProductStatus(Long prNo, ProductStatus prStatus) {
        productMapper.updateProductStatus(prNo, prStatus);

        if (prStatus == ProductStatus.DELETE) {
            productMapper.deleteProductFile(prNo);
        }

        return prNo;
    }

    /**
     * 상품 상태 일괄 변경
     **/
    public Long[] updateProductStatusAtOnce(Long[] prNos, ProductStatus prStatus) {
        productMapper.updateProductStatusAtOnce(prNos, prStatus);

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
        productMapper.deleteSellProduct(spNo);

        return spNo;
    }

    public Long updateSellProduct(SellProductDTO sellProductDTO) {
        productMapper.updateSellProduct(sellProductDTO);

        return sellProductDTO.getSpNo();
    }
}
