package org.plateer.fittingroombo.room.service;

import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;

import java.util.List;

public interface RoomService {
    PageResultDTO<RequestHistoryDTO> getRoomRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    Long insertRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO);

    List<RequestHistoryDTO> getRequestHistoryPlace(Long pmNo);

    Long updateRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO);
}
