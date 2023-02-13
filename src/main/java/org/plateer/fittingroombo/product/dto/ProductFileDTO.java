package org.plateer.fittingroombo.product.dto;

import lombok.Data;

@Data
public class ProductFileDTO {
    private Long prfNo;
    private String prfName;
    private String prfUuid;
    private String prfType;
    private Boolean prfStatus;
    private Long prNo;
}
