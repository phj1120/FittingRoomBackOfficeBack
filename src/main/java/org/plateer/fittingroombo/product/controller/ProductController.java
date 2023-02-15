package org.plateer.fittingroombo.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.util.ImageUtil;
import org.plateer.fittingroombo.product.dto.*;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;
import org.plateer.fittingroombo.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/seller")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ImageUtil imageUtil;

    @GetMapping("/product/list")
    public PageResultDTO<ProductDTO> productDTO(Long seNo, ProductPageSearchRequestDTO productPageSearchRequestDTO) {
        PageResultDTO<ProductDTO> result = productService.getProductList(seNo, productPageSearchRequestDTO);

        return result;
    }

    /**
     * 상세 조회
     **/
    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        ProductDTO product = productService.getProduct(id);

        return product;
    }

    /**
     * 상품 추가
     **/
    @PostMapping("/product")
    public ResultDTO<Long> insertProduct(ProductInsertDTO productInsertDTO) {
        // 이미지 저장
        List<ProductFileDTO> topFiles = imageUtil.saveTopImages(productInsertDTO); // TOP
        List<ProductFileDTO> BottomFiles = imageUtil.saveBottomImages(productInsertDTO); // BOTTOM

        // 상품 저장
        ProductDTO productDTO = new ProductDTO(productInsertDTO, topFiles, BottomFiles);
        Long result = productService.insertProduct(productDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 상품 수정
     **/
    @PutMapping("/product/{prNo}")
    public ResultDTO<Long> updateProduct(@PathVariable Long prNo, ProductInsertDTO productInsertDTO) {
        // 이전 파일 삭제
        productService.deleteProductFile(prNo);

        // 이미지 저장
        List<ProductFileDTO> topFiles = imageUtil.saveTopImages(productInsertDTO); // TOP
        List<ProductFileDTO> BottomFiles = imageUtil.saveBottomImages(productInsertDTO); // BOTTOM

        ProductDTO productDTO = new ProductDTO(productInsertDTO, topFiles, BottomFiles);
        productDTO.setPrNo(prNo);

        // 상품 수정
        Long result = productService.updateProduct(productDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 상품 상태 수정(활성/비활성/품절/삭제)
     **/
    @PutMapping("/product/status/{prNo}")
    public ResultDTO<Long> updateProductStatus(@PathVariable Long prNo, ProductStatus prStatus) {
        Long result = productService.updateProductStatus(prNo, prStatus);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 상품 상태 일괄 수정(활성/비활성/품절/삭제)
     **/
    @PutMapping("/product/status")
    public ResultDTO<Long[]> updateProductStatusAtOnce(@RequestParam(value="prNos") Long[] prNos, ProductStatus prStatus) {

        Long[] result = productService.updateProductStatusAtOnce(prNos, prStatus);

        return ResultDTO.<Long[]>builder().data(result).build();
    }

    /**
     * 판매 상세 조회
     **/
    @GetMapping("/sellproduct/{prNo}")
    public List<SellProductDTO> getSellProduct(@PathVariable Long prNo) {
        List<SellProductDTO> sellProductDTOList = productService.getSellerProduct(prNo);

        return sellProductDTOList;
    }

    /**
     * 판매 상품 추가
     **/
    @PostMapping("/sellproduct/{prNo}")
    public ResultDTO<Long> insertSellProduct(@PathVariable Long prNo,
                                             @RequestBody SellProductDTO sellProductDTO) {
        // 추후 request 로 변경 시 처리 하도록
        sellProductDTO.setPrNo(prNo);
        sellProductDTO.setSpCreateDt(LocalDateTime.now());
        Long result = productService.insertSellProduct(sellProductDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 판매 상품 삭제
     **/
    @DeleteMapping("/sellproduct/{spNo}")
    public ResultDTO<Long> deleteSellProduct(@PathVariable Long spNo) {
        Long result = productService.deleteSellProduct(spNo);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 판매 상품 수정
     **/
    @PutMapping("/sellproduct/{spNo}")
    public ResultDTO<Long> updateSellProduct(@PathVariable Long spNo,
                                             @RequestBody SellProductDTO sellProductDTO) {
        // 추후 request 로 변경 시 처리 하도록
        sellProductDTO.setSpNo(spNo);
        sellProductDTO.setSpModifyDt(LocalDateTime.now());
        Long result = productService.updateSellProduct(sellProductDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

}
