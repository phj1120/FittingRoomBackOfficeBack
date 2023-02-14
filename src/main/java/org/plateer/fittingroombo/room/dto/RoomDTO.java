package org.plateer.fittingroombo.room.dto;


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
public class RoomDTO {
    private Long rNo;

    private String rName;
    private String rAddress;
    private String rDetailAddress;
    private String rPostcode;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime rCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime rModifyDt;

    public RoomDTO (String rName, String rAddress, String rDetailAddress, String rPostcode) {
        this.rName = rName;
        this.rAddress = rAddress;
        this.rDetailAddress = rDetailAddress;
        this.rPostcode = rPostcode;
        this.rCreateDt = LocalDateTime.now();
    }
}