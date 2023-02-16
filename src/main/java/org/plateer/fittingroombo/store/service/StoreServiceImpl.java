package org.plateer.fittingroombo.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.store.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;
    private final RequestHistoryMapper requestHistoryMapper;

    @Override
    public PageResultDTO<RequestHistoryDTO> getStoreList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        int total = requestHistoryMapper.getCount(requestHistoryPageRequestDTO);
        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getStoreRequestHistoryList(requestHistoryPageRequestDTO);
        PageResultDTO<RequestHistoryDTO> pageResultDTO = PageResultDTO.<RequestHistoryDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(requestHistoryPageRequestDTO)
                .build();
        return pageResultDTO;
    }

    @Override
    public String getStoreStatus(Long seNo) {

        return storeMapper.getStoreStatus(seNo);
    }


    @Override
    public Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO) {
        requestHistoryDTO.setRhCreateDt(LocalDateTime.now());
        requestHistoryDTO.setRhStatus("대기");
        //로그인 붙으면 수정해야함.
        //requestHistoryDTO.setSeNo(1L);
        requestHistoryMapper.insertRequestHistorySeller(requestHistoryDTO);
        Long rhNo = requestHistoryDTO.getRhNo();
        return rhNo;
    }

    @Override
    public Long updateRequestHistorySeller(RequestHistoryDTO updateHistoryObj) {
        Long updateRow = requestHistoryMapper.updateRequestHistorySeller(updateHistoryObj);
        return updateRow;
    }

    @Override
    public RequestHistoryDTO getRequestHistoryDetailSeller(Long rhNo) {
        RequestHistoryDTO requestHistoryDTO = requestHistoryMapper.getRequestHistoryDetailSeller(rhNo);
        log.info("=======================================");
        log.info("=======================================");
        log.info(requestHistoryDTO);
        return requestHistoryDTO;
    }


}
