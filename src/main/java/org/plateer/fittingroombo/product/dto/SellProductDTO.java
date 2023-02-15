package org.plateer.fittingroombo.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellProductDTO {
    private Long spNo;
    private String spSize;
    private ProductStatus spStatus;
    private LocalDateTime spCreateDt;
    private LocalDateTime spModifyDt;
    private Long prNo;

    public SellProductDTO(Long prNo, String spSize, ProductStatus spStatus) {
        this.spSize = spSize;
        this.spStatus = spStatus;
        this.prNo = prNo;
        this.spCreateDt = LocalDateTime.now();
    }
}
