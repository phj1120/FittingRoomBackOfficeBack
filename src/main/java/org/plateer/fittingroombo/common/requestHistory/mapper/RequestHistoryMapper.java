package org.plateer.fittingroombo.common.requestHistory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface RequestHistoryMapper {
    int getCount(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    List<RequestHistoryDTO> getStoreRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);
    Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);
    Long updateRequestHistorySeller(RequestHistoryDTO updateHistoryObj);

    RequestHistoryDTO getRequestHistoryDetailSeller(Long rhNo);
}
