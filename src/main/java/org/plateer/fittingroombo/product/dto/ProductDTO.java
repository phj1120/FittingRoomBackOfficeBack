package org.plateer.fittingroombo.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ProductDTO {
    private Long prNo;
    private String prBrand;
    private String prName;
    private Long prPrice;
    private ProductStatus prStatus;
    private LocalDateTime prCreateDt;
    private LocalDateTime prModifyDt;
    private Long prcNo; // 상품 카테고리 번호
    private Long seNo; // 판매자 번호
    private List<ProductFileDTO> topFiles = new ArrayList<>();
    private List<ProductFileDTO> bottomFiles = new ArrayList<>();
    private List<SellProductDTO> options = new ArrayList<>();
    private String thumbnail;
    private Integer thumbnailIndex;
    private String categoryPathName;
    private String categoryPathNo;

    @Builder
    public ProductDTO(String prBrand, String prName, Long prPrice, ProductStatus prStatus, Long prcNo, Long seNo) {
        this.prBrand = prBrand;
        this.prName = prName;
        this.prPrice = prPrice;
        this.prStatus = prStatus;
        this.prcNo = prcNo;
        this.seNo = seNo;

        // 생성시 기본 값
        this.prCreateDt = LocalDateTime.now();
    }

    public void setPrNo(Long prNo) {
        this.prNo = prNo;
    }

    public void setOptions(List<SellProductDTO> options) {
        this.options = options;
    }

    public void setPrBrand(String prBrand) {
        this.prBrand = prBrand;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public void setPrPrice(Long prPrice) {
        this.prPrice = prPrice;
    }

    public void setPrStatus(ProductStatus prStatus) {
        this.prStatus = prStatus;
    }

    public void setPrModifyDt(LocalDateTime prModifyDt) {
        this.prModifyDt = prModifyDt;
    }

    public void setTopFiles(List<ProductFileDTO> topFiles) {
        this.topFiles = topFiles;
    }

    public void setBottomFiles(List<ProductFileDTO> bottomFiles) {
        this.bottomFiles = bottomFiles;
    }

    /**
     * 상품 추가
     **/
    public ProductDTO(ProductInsertDTO productInsertDTO, List<ProductFileDTO> topFiles, List<ProductFileDTO> bottomFiles) {
        this.prBrand = productInsertDTO.getPrBrand();
        this.prName = productInsertDTO.getPrName();
        this.prPrice = productInsertDTO.getPrPrice();
        this.prStatus = productInsertDTO.getPrStatus();
        this.prCreateDt = LocalDateTime.now();
        this.prcNo = productInsertDTO.getPrcNo();
        this.seNo = 1L; // 사용자
        this.topFiles = topFiles;
        this.bottomFiles = bottomFiles;
    }
}
