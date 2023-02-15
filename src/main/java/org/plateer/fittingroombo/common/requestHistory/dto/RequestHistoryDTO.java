package org.plateer.fittingroombo.common.requestHistory.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestHistoryDTO {
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


    // 판매자가 장소제공자에게 요청
    public RequestHistoryDTO(String rhStatus, String rhContent, String rhReason, LocalDateTime rhStartDt, Long pmNo, Long seNo) {
        this.rhStatus = rhStatus;
        this.rhContent = rhContent;
        this.rhReason = rhReason;
        this.rhStartDt = rhStartDt;
        this.rhCreateDt = LocalDateTime.now();
        this.pmNo = pmNo;
        this.seNo = seNo;
    }

    // 장소제공자가 슈퍼관리자에게 요청
    public RequestHistoryDTO(String rhStatus, String rhContent, String rhReason, LocalDateTime rhStartDt, Long pmNo) {
        this.rhStatus = rhStatus;
        this.rhContent = rhContent;
        this.rhReason = rhReason;
        this.rhStartDt = rhStartDt;
        this.rhCreateDt = LocalDateTime.now();
        this.pmNo = pmNo;
    }

    // 장소제공자 요청 수정
    public RequestHistoryDTO(Long rhNo, String rhContent, String rhReason, LocalDateTime rhStartDt) {
        this.rhNo = rhNo;
        this.rhContent = rhContent;
        this.rhReason = rhReason;
        this.rhStartDt = rhStartDt;
    }

    // 장소제공자 요청 온 항목 DTO
    public RequestHistoryDTO(Long pmNo) {
        this.pmNo = pmNo;
    }
}
