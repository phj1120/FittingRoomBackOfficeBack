package org.plateer.fittingroombo.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.security.dto.CustomUserDetail;
import org.plateer.fittingroombo.common.util.image.ImageUtil;
import org.plateer.fittingroombo.product.dto.*;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;
import org.plateer.fittingroombo.product.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 상품 관리 Controller
 * 작성자: 이수영, 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@RestController
@RequestMapping("api/seller")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ImageUtil imageUtil;

    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("/product/list")
    public PageResultDTO<ProductDTO> getProductList(@AuthenticationPrincipal CustomUserDetail user,
                                                ProductPageSearchRequestDTO productPageSearchRequestDTO) {
        Long seNo = user.getUserNo();
        PageResultDTO<ProductDTO> result = productService.getProductList(seNo, productPageSearchRequestDTO);

        return result;
    }

    /**
     * 상세 조회
     **/
    @PreAuthorize("#user !=null && @productChecker.hasPermission(#user.userNo, #prNo)")
    @GetMapping("/product/{prNo}")
    public ProductDTO getProduct(
            @AuthenticationPrincipal CustomUserDetail user,
            @PathVariable("prNo") Long prNo) {
        ProductDTO product = productService.getProduct(prNo);

        return product;
    }

    /**
     * 상품 추가
     **/
    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/product")
    public ResultDTO<Long> insertProduct(@AuthenticationPrincipal CustomUserDetail user,
                                         ProductInsertDTO productInsertDTO) {
        Long seNo = user.getUserNo();

        // 이미지 저장
        List<ProductFileDTO> topFiles = imageUtil.saveTopImages(productInsertDTO); // TOP
        List<ProductFileDTO> BottomFiles = imageUtil.saveBottomImages(productInsertDTO); // BOTTOM

        // 상품 저장
        ProductDTO productDTO = new ProductDTO(productInsertDTO, seNo, topFiles, BottomFiles);
        Long result = productService.insertProduct(productDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 상품 수정
     *
     **/
    @PreAuthorize("#user !=null && @productChecker.hasPermission(#user.userNo, #prNo)")
    @PutMapping("/product/{prNo}")
    public ResultDTO<Long> updateProduct(
            @AuthenticationPrincipal CustomUserDetail user,
            @PathVariable Long prNo, ProductInsertDTO productInsertDTO) {
        if (productInsertDTO.getPrStatus().equals(ProductStatus.DELETE)) {
            throw new IllegalArgumentException("해당 요청으로 삭제 불가");
        }
        Long seNo = user.getUserNo();

        // 이전 파일 삭제
        productService.deleteProductFile(prNo);

        // 이미지 저장
        List<ProductFileDTO> topFiles = imageUtil.saveTopImages(productInsertDTO); // TOP
        List<ProductFileDTO> BottomFiles = imageUtil.saveBottomImages(productInsertDTO); // BOTTOM

        ProductDTO productDTO = new ProductDTO(productInsertDTO, seNo, topFiles, BottomFiles);
        productDTO.setPrNo(prNo);

        // 상품 수정
        Long result = productService.updateProduct(productDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /*
     * 상품 삭제
     * */
    @PreAuthorize("#user !=null && @productChecker.hasPermission(#user.userNo, #prNo)")
    @DeleteMapping("/product/{prNo}")
    public ResultDTO<Long> deleteProduct(
            @AuthenticationPrincipal CustomUserDetail user,
            @PathVariable Long prNo) {
        // 이전 파일 삭제
        productService.deleteProductFile(prNo);

        // 상품 삭제
        Long result = productService.deleteProduct(prNo);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 상품 상태 일괄 수정(활성/비활성/품절/삭제)
     **/
    @PreAuthorize("#user !=null && @productChecker.hasPermission(#user.userNo, #updateProductStatusRequestDTO)")
    @PutMapping("/product/status")
    public ResultDTO<List<Long>> updateProductStatusAtOnce(
            @AuthenticationPrincipal CustomUserDetail user,
            @RequestBody UpdateProductStatusRequestDTO updateProductStatusRequestDTO) {
        List<Long> result = productService.updateProductStatusAtOnce(updateProductStatusRequestDTO);

        return ResultDTO.<List<Long>>builder().data(result).build();
    }

    /**
     * 판매 상세 조회
     **/
    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("/sellproduct/{prNo}")
    public List<SellProductDTO> getSellProduct(@PathVariable Long prNo) {
        List<SellProductDTO> sellProductDTOList = productService.getSellerProduct(prNo);

        return sellProductDTOList;
    }

    /**
     * 판매 상품 추가
     **/
    @PreAuthorize("hasRole('SELLER')")
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
    @PreAuthorize("hasRole('SELLER')")
    @DeleteMapping("/sellproduct/{spNo}")
    public ResultDTO<Long> deleteSellProduct(@PathVariable Long spNo) {
        Long result = productService.deleteSellProduct(spNo);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /**
     * 판매 상품 수정
     **/
    @PreAuthorize("hasRole('SELLER')")
    @PutMapping("/sellproduct/{spNo}")
    public ResultDTO<Long> updateSellProduct(@PathVariable Long spNo,
                                             @RequestBody SellProductDTO sellProductDTO) {
        // 추후 request 로 변경 시 처리 하도록
        sellProductDTO.setSpNo(spNo);
        sellProductDTO.setSpModifyDt(LocalDateTime.now());
        Long result = productService.updateSellProduct(sellProductDTO);

        return ResultDTO.<Long>builder().data(result).build();
    }

    /*
     * 카테고리 목록 조회
     * */
    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("/product/categories")
    public ResultDTO<List<ProductCategoryDTO>> getCategories() {
        List<ProductCategoryDTO> result = productService.getProductCategoryList();

        return ResultDTO.<List<ProductCategoryDTO>>builder().data(result).build();
    }
}
