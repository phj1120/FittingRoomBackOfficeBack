package org.plateer.fittingroombo.common.requestHistory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestHistoryDTO {
    private Long rhNo;
    
    private String rhStatus;  /* 승인, 거절, 대기 */
    private String rhContent;  /* 가입, 휴업, 탈퇴 */

    private String rhReason;
    private LocalDate rhCreateDt;

    private String rhStartDt;

    private Long pmNo;

    private Long sNo;


}
