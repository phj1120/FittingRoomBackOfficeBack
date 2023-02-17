package org.plateer.fittingroombo.common.requestHistory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.springframework.stereotype.Component;
import org.plateer.fittingroombo.seller.dto.SellerRequestDTO;

import java.util.List;

@Mapper
public interface RequestHistoryMapper {
    List<RequestHistoryDTO> getStoreRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);
    
    Long updateRequestHistorySeller(RequestHistoryDTO updateHistoryObj);

    RequestHistoryDTO getRequestHistoryDetailSeller(Long rhNo);
    
    // Request 총 개수 구하기
    int getCount(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    // 장소제공자에게 요청 온 Request 총 개수 구하기
    int getRoomSellerCount(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    // 판매자 대기상태 총 개수 구하기
    int getSellerRequestCount(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    // Request 조회
    List<RequestHistoryDTO> getRoomRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    // Request 등록
    Long insertRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO);

    // Request 수정
    Long updateRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO);
    
    // 특정 장소제공자애게 요청 후 대기 상태인 Request 현황
    List<SellerRequestDTO> getRoomSellerRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    // 특정 장소제공자에게 요청 된 기록 리스트
    List<RequestHistoryDTO> getRoomSellerRequestHistoryAllList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);
    
    // 승인 및 거절 처리 후 새로운 등록
    Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);
}
