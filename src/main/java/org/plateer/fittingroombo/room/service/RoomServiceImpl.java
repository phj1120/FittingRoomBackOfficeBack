package org.plateer.fittingroombo.room.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RequestHistoryMapper requestHistoryMapper;

    @Override
    public PageResultDTO<RequestHistoryDTO> getRoomRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        int total = requestHistoryMapper.getCount(requestHistoryPageRequestDTO);
        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getRoomRequestHistoryList(requestHistoryPageRequestDTO);

        PageResultDTO<RequestHistoryDTO> pageResultDTO = PageResultDTO.<RequestHistoryDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(requestHistoryPageRequestDTO)
                .build();
        return pageResultDTO;
    }

    @Override
    public Long insertRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO) {
        requestHistoryMapper.insertRequestHistoryPlace(requestHistoryDTO);
        return requestHistoryDTO.getRhNo();
    }

    @Override
    public List<RequestHistoryDTO> getRequestHistoryPlace(Long pmNo) {
        return requestHistoryMapper.getRequestHistoryPlace(pmNo);
    }

    @Override
    public Long updateRequestHistoryPlace(RequestHistoryDTO requestHistoryDTO) {
        requestHistoryMapper.updateRequestHistoryPlace( requestHistoryDTO );
        return requestHistoryDTO.getRhNo();
    }
}
