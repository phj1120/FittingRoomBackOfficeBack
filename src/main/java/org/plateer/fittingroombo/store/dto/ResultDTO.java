package org.plateer.fittingroombo.store.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class ResultDTO {
    private List<SellerStatusDTO> resultList;
    private String seStatus;
     public ResultDTO(List<SellerStatusDTO> resultList, String sStatus){

        this.resultList = resultList;
        this.seStatus = sStatus;
    }
}

