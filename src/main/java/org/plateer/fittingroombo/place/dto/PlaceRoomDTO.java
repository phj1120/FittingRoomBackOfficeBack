package org.plateer.fittingroombo.place.dto;


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
public class PlaceRoomDTO {
    // 방번호
    private Long roNo;
    
    // 지점 이름
    private String roName;

    // 주소 및 우편번호
    private String roAddress;
    private String roDetailAddress;
    private String roPostCode;

    // 영업 상태
    private String pmStatus;

    // 담당자 이름
    private String pmName;

    // 피팅룸 전화번호
    private String pmPhone;

    // 피팅룸 담당자 ID
    private Long pmNo;

    // 개설일
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime roCreateDt;
}