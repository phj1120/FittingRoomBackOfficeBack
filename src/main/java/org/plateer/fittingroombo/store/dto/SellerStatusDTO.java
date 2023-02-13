package org.plateer.fittingroombo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerStatusDTO {

    private Long rhNo;

    private String rhStatus;  /* 승인, 거절, 대기 */
    private String rhContent;  /* 가입, 휴업, 탈퇴 */

    private String rhReason;

    private String rhStartDt;

}
