package org.plateer.fittingroombo.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
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
    private Boolean prStatus; // Y: 활성, N: 비활성
    private LocalDateTime prCreateDt;
    private LocalDateTime prModifyDt;
    private Long prcNo; // 상품 카테고리 번호
    private Long seNo; // 판매자 번호
    private List<ProductFileDTO> files = new ArrayList<>();
    private List<SellProductDTO> options = new ArrayList<>();
    private String thumbnail;
    private String category;

    @Builder
    public ProductDTO(String prBrand, String prName, Long prPrice, Long prcNo, Long sNo) {
        this.prBrand = prBrand;
        this.prName = prName;
        this.prPrice = prPrice;
        this.prcNo = prcNo;
        this.seNo = sNo;

        // 생성시 기본 값
        this.prCreateDt = LocalDateTime.now();
        this.prStatus = true;
    }

    public void setPrNo(Long prNo) {
        this.prNo = prNo;
    }

    public void setFiles(List<ProductFileDTO> files) {
        this.files = files;
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

    public void setPrStatus(boolean prStatus) {
        this.prStatus = prStatus;
    }

    public void setPrModifyDt(LocalDateTime prModifyDt) {
        this.prModifyDt = prModifyDt;
    }

    /**
     * 상품 추가
     **/
    public ProductDTO(ProductInsertDTO productInsertDTO, List<ProductFileDTO> files) {
        this.prBrand = productInsertDTO.getPrBrand();
        this.prName = productInsertDTO.getPrName();
        this.prPrice = productInsertDTO.getPrPrice();
        this.prStatus = true;
        this.prCreateDt = LocalDateTime.now();
        this.prcNo = productInsertDTO.getPrcNo();
        this.seNo = 1L; // 사용자
        this.files = files;
    }

}
