package org.plateer.fittingroombo.product.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductOptionDTO {
    private Long spNo;
    private String spSize;
    private String spStatus;
    private LocalDateTime spCreateDt;
    private LocalDateTime spModifyDt;
    private Long prNo;

}
