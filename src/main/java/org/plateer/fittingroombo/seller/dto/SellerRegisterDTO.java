package org.plateer.fittingroombo.seller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerRegisterDTO {

    private Long seNo;
    private String seName;
    private String seManager;
    private String seId;
    private String sePassword;
    private String seEmail;
    private String sePhone;
    private String seAddress;
    private String seStatus; // Enum
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime seCreateDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime seModifyDt;
    private Long pmNo;

    private MultipartFile image;

    private SellerFileDTO saveImage;
}
