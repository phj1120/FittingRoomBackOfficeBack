package org.plateer.fittingroombo.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.ProductFileDTO;
import org.plateer.fittingroombo.product.dto.ProductInsertDTO;
import org.plateer.fittingroombo.product.dto.ProductPageSearchRequestDTO;
import org.plateer.fittingroombo.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    /**
     * 상품 추가
     **/
    public Long insertProduct(ProductDTO productDTO) {
        // product 추가
        productMapper.insertProduct(productDTO);

        // images 추가
        productDTO.getFiles().stream().forEach(productFileDTO -> {
            productFileDTO.setPrNo(productDTO.getPrNo());
            productMapper.insertProductFile(productFileDTO);
        });

        return productDTO.getPrNo();
    }

    /**
     * 상품 삭제(비활성화)
     **/
    public void deleteProduct(Long id) {
        // product 삭제
        productMapper.deleteProduct(id);

        // images 삭제
        productMapper.deleteProductFile(id);
    }
    
    /**
     * 상품 수정
     **/
    public Long updateProduct(ProductDTO productDTO) {
        // 이전 파일 삭제
        productMapper.deleteProductFile(productDTO.getPrNo());

        // 새로운 파일 추가
        productDTO.getFiles().stream().forEach(productFileDTO -> {
            productFileDTO.setPrNo(productDTO.getPrNo());
            productMapper.insertProductFile(productFileDTO);
        });

        // product 수정
        productMapper.updateProduct(productDTO);

        return productDTO.getPrNo();
    }

}
