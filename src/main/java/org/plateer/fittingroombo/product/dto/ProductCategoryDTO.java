package org.plateer.fittingroombo.product.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {
    private Long prcNo;
    private String prcName;
    private Integer prcDepth;
    private Integer prcPosition;
    private LocalDate prcCreateDt;
    private LocalDate prcModifyDt;
    private Long pPrcNo;

    public ProductCategoryDTO(String prcName, Integer prcDepth, Integer prcPosition, Long pPrcNo) {
        this.prcName = prcName;
        this.prcDepth = prcDepth;
        this.prcPosition = prcPosition;
        this.prcCreateDt = LocalDate.now();
        this.pPrcNo = pPrcNo;
    }
}
