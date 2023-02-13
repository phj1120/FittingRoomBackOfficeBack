package org.plateer.fittingroombo.seller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {
    private Long sNo;
    private String sName;
    private String sManager;
    private String sId;
    private String sPassword;
    private String sEmail;
    private String sPhone;
    private String sAddress;
    private String sStatus; // Enum
    private LocalDate sCreateDt;
    private LocalDate sModifyDt;
    private Long pmNo;

}
