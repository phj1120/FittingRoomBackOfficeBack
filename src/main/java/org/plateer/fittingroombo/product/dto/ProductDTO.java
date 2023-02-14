package org.plateer.fittingroombo.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
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
    private LocalDate prCreateDt;
    private LocalDate prModifyDt;
    private Long prcNo; // 상품 카테고리 번호
    private Long seNo; // 판매자 번호
    private List<ProductFileDTO> files = new ArrayList<>();
    private List<SellProductDTO> options = new ArrayList<>();
    private String thumbnail;
    private String category;

    @Builder
    public ProductDTO(String prBrand, String prName, Long prPrice, Long prcNo, Long seNo) {
        this.prBrand = prBrand;
        this.prName = prName;
        this.prPrice = prPrice;
        this.prcNo = prcNo;
        this.seNo = seNo;

        // 생성시 기본 값
        this.prCreateDt = LocalDate.now();
        this.prStatus = true;
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

    public void setPrModifyDt(LocalDate prModifyDt) {
        this.prModifyDt = prModifyDt;
    }
}
