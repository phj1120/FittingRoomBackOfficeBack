package org.plateer.fittingroombo.product.dto;

import lombok.*;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFileDTO {
    private Long prfNo;
    private String prfName;
    private String prfUuid;
    private ProductFileType prfType;
    private Boolean prfStatus; // Y: 대표 이미지 / N: 일반 이미지
    private Long prNo;

    public ProductFileDTO(String prfName, String prfUuid) {
        this.prfName = prfName;
        this.prfUuid = prfUuid;
    }

    public ProductFileDTO(String prfName, String prfUuid, ProductFileType prfType, Long prNo) {
        this.prfName = prfName;
        this.prfUuid = prfUuid;
        this.prfType = prfType;
        this.prNo = prNo;
    }
}
