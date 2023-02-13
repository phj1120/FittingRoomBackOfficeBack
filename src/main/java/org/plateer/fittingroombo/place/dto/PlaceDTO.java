package org.plateer.fittingroombo.place.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


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
    private LocalDateTime pmCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime pmModifyDt;


    public PlaceDTO(String pmName, String pmBirth, String pmId, String pmPassword, String pmEmail, String pmPhone, String pmStatus, Long rNo) {
        this.pmName = pmName;
        this.pmBirth = pmBirth;
        this.pmId = pmId;
        this.pmPassword = pmPassword;
        this.pmEmail = pmEmail;
        this.pmPhone = pmPhone;
        this.pmStatus = pmStatus;
        this.rNo = rNo;

        this.pmCreateDt = LocalDateTime.now();
    }
}