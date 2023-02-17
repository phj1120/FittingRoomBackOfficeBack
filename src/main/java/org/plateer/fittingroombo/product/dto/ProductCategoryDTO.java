package org.plateer.fittingroombo.product.dto;

import lombok.*;

import java.time.LocalDateTime;

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
    private String prcPathName;
    private String prcPathNo;
    private LocalDateTime prcCreateDt;
    private LocalDateTime prcModifyDt;
    private Long prcNoP;

    public ProductCategoryDTO(String prcName, Integer prcDepth, Integer prcPosition, Long prcNoP) {
        this.prcName = prcName;
        this.prcDepth = prcDepth;
        this.prcPosition = prcPosition;
        this.prcCreateDt = LocalDateTime.now();
        this.prcNoP = prcNoP;
    }
}
