package org.plateer.fittingroombo.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class ProductListDTO {

    private Long prNo;
    private String prBrand;
    private String prName;
    private Long prPrice;
    private LocalDate prCreateDt;
    private LocalDate prModifyDt;
    private Boolean prStatus;
    private String prThumbnail;
}
