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
public class PlaceRegisterDTO {
    // 장소제공자, 장소 번호
    private Long pmNo;
    private Long roNo;

    // 장소제공자 정보
    private String pmName;
    private String pmBirth;
    private String pmId;
    private String pmPassword;
    private String pmEmail;
    private String pmPhone;
    private String pmStatus;

    // 장소 정보
    private String roName;
    private String roAddress;
    private String roDetailAddress;
    private String roPostcode;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime pmCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime pmModifyDt;
}