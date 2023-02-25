package org.plateer.fittingroombo.cart.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartProductListDTO {
    private Long prNo;
    private String prName;
    private Long prPrice;

    private String spSize;
    private Long cpNo;
    private Boolean cpStatus;


}
