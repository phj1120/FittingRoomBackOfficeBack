package org.plateer.fittingroombo.product.dto;

import lombok.*;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCrawlingDTO {
    private Long prNo;
    private Long seNo;

    private String prBrand;
    private String prName;
    private Long prPrice;

    private String prStatus;
    private String prFileName;
}
