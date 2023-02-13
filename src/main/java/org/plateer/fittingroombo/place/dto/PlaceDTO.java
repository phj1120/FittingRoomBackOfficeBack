package org.plateer.fittingroombo.place.dto;


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
public class PlaceDTO {
    private Long pmNo;

    private String pmName;
    private String pmBirth;
    private String pmId;
    private String pmPassword;
    private String pmEmail;
    private String pmPhone;
    private String pmStatus;

    private Long rNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pmCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pmModifyDt;
}