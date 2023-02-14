package org.plateer.fittingroombo.seller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {
    private Long seNo;

    private String seName;
    private String seManager;
    private String seId;
    private String sePassword;
    private String seEmail;
    private String sePhone;
    private String seAddress;
    private String seStatus;

    private Long pmNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime seCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime seModifyDt;

}
