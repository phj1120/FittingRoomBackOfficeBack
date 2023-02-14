package org.plateer.fittingroombo.common.requestHistory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.springframework.stereotype.Component;

@Mapper
public interface RequestHistoryMapper {

    Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);
    Long updateRequestHistorySeller(RequestHistoryDTO updateHistoryObj);

    RequestHistoryDTO getRequestHistoryDetailSeller(Long rhNo);
}
