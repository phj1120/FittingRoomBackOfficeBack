package org.plateer.fittingroombo.product.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductCategoryDTO {
    private Long prcNo;
    private String prcName;
    private Integer prcDepth;
    private Integer prcPosition;
    private String prcStatus;
    private LocalDate prcCreateDt;
    private LocalDate prcModifyDt;

}
