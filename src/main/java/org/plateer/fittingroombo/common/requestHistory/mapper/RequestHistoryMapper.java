package org.plateer.fittingroombo.common.requestHistory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;

import java.util.List;

@Mapper
public interface RequestHistoryMapper {
    // Request 총 개수 구하기
    int getCount(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    // Request 조회
    List<RequestHistoryDTO> getRoomRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    // Request 등록
    Long insertRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO);

    // Request 수정
    Long updateRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO);
}
