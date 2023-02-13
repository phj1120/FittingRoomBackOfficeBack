package org.plateer.fittingroombo.product.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SellProductDTO {
    private Long spNo;
    private String spSize;
    private SellProductStatus spStatus;
    private LocalDateTime spCreateDt;
    private LocalDateTime spModifyDt;
    private Long prNo;

}
