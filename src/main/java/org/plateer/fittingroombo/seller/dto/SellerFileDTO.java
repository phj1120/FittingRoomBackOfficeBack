package org.plateer.fittingroombo.seller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerFileDTO {

    private Long sfNo;               // 파일 번호

    private String sfUuid;        // UUID

    private String sfName;    // 파일 이름

    private Long seNo;               // 롤링 번호

    public SellerFileDTO(String sfUuid, String sfName) {
        this.sfUuid = sfUuid;
        this.sfName = sfName;
    }
}
