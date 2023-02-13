package org.plateer.fittingroombo.product.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO {
    private Long prNo;
    private String prBrand;
    private String prName;
    private Long prPrice;
    private boolean prStatus; // Y: 활성, N: 비활성
    private LocalDate prCreateDt;
    private LocalDate prModifyDt;
    private Long prcNo; // 상품 카테고리 번호
    private Long sNo; // 판매자 번호
    private List<ProductFileDTO> files = new ArrayList<>();
    private List<SellProductDTO> options = new ArrayList<>();

    @Builder
    public ProductDTO(String prBrand, String prName, Long prPrice, Long prcNo, Long sNo) {
        this.prBrand = prBrand;
        this.prName = prName;
        this.prPrice = prPrice;
        this.prcNo = prcNo;
        this.sNo = sNo;

        // 생성시 기본 값
        this.prCreateDt = LocalDate.now();
        this.prStatus = true;
    }
}
