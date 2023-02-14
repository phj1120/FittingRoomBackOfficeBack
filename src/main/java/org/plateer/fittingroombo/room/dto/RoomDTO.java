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

    private String roName;
    private String roAddress;
    private String roDetailAddress;
    private String roPostcode;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime roCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime roModifyDt;

    public RoomDTO (String roName, String roAddress, String roDetailAddress, String roPostcode) {
        this.roName = roName;
        this.roAddress = roAddress;
        this.roDetailAddress = roDetailAddress;
        this.roPostcode = roPostcode;
        this.roCreateDt = LocalDateTime.now();
    }
}