package org.plateer.fittingroombo.room.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


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
    private LocalDate rCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rModifyDt;
}