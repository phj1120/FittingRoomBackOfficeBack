package org.plateer.fittingroombo.place.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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

    // 장소 사진
    private List<MultipartFile> images = new ArrayList<>(); // 이미지 파일
    private List<PlaceFileDTO> roomImages = new ArrayList<>(); // 이미지
    private Integer thumbnail; // 대표사진
}