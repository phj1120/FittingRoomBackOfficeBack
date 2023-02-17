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

    private Long roNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime pmCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime pmModifyDt;


    public PlaceDTO(String pmName, String pmBirth, String pmId, String pmPassword, String pmEmail, String pmPhone, String pmStatus, Long roNo) {
        this.pmName = pmName;
        this.pmBirth = pmBirth;
        this.pmId = pmId;
        this.pmPassword = pmPassword;
        this.pmEmail = pmEmail;
        this.pmPhone = pmPhone;
        this.pmStatus = pmStatus;
        this.roNo = roNo;

        this.pmCreateDt = LocalDateTime.now();
    }

    public PlaceDTO(Long pmNo, String pmPassword, String pmEmail, String pmPhone) {
        this.pmNo = pmNo;
        this.pmPassword = pmPassword;
        this.pmEmail = pmEmail;
        this.pmPhone = pmPhone;

        this.pmModifyDt = LocalDateTime.now();
    }

    public PlaceDTO(Long pmNo, String pmStatus) {
        this.pmNo = pmNo;
        this.pmStatus = pmStatus;

        this.pmModifyDt = LocalDateTime.now();
    }
}