package org.plateer.fittingroombo.seller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequestDTO {
    private Long rhNo;

    // 요청에 대한 상태 ( 승인, 거절, 대기 )
    private String rhStatus;
    // 요청에 대한 항목 ( 가입, 휴업, 탈퇴 )
    private String rhContent;
    private String rhReason;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime rhStartDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime rhCreateDt;

    private Long pmNo;
    private Long seNo;


    private String seName;
    private String seManager;
    private String seEmail;
    private String sePhone;
    private String seAddress;
    private String seStatus;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime seCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime seModifyDt;

}
