package org.plateer.fittingroombo.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductFileDTO {
    private Long prfNo;
    private String prfName;
    private String prfUUID;
    private ProductFileType prfType;
    private Boolean prfStatus; // Y: 활성 /. N: 비활성
    private Long prNo;

    public ProductFileDTO(String prfName, String prfUUID) {
        this.prfName = prfName;
        this.prfUUID = prfUUID;
    }
}
