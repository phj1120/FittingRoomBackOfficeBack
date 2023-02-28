package org.plateer.fittingroombo.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.mapper.SellerMapper;
import org.plateer.fittingroombo.store.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 영업관리 service
 * 작성자 : 주호승
 * 일시 : 2023-02-17
 * 버전 : v1
 **/
@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;
    private final RequestHistoryMapper requestHistoryMapper;

    private final SellerMapper sellerMapper;

    @Override
    public PageResultDTO<RequestHistoryDTO> getStoreList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        int total = requestHistoryMapper.getSellerCount(requestHistoryPageRequestDTO);
        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getStoreRequestHistoryList(requestHistoryPageRequestDTO);
        PageResultDTO<RequestHistoryDTO> pageResultDTO = PageResultDTO.<RequestHistoryDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(requestHistoryPageRequestDTO)
                .build();
        return pageResultDTO;
    }

    @Override
    public SellerDTO getStoreStatus(Long seNo) {

        return storeMapper.getStoreStatus(seNo);
    }


    @Override
    public Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO) {
        requestHistoryDTO.setRhCreateDt(LocalDate.now());
        requestHistoryDTO.setRhStatus("대기");
        requestHistoryMapper.insertRequestHistorySeller(requestHistoryDTO);
        Long rhNo = requestHistoryDTO.getRhNo();
        return rhNo;
    }
    @Override
    public Long modifyRequestHistorySeller(RequestHistoryDTO requestHistoryDTO) {
        requestHistoryDTO.setRhCreateDt(LocalDate.now());
        requestHistoryDTO.setRhStatus("대기");
        Long pmNo = sellerMapper.getSellerByNo(requestHistoryDTO.getSeNo());
        log.info("================================");
        log.info("================================");
        log.info("================================");
        log.info(pmNo);
        requestHistoryDTO.setPmNo(pmNo);
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
        return requestHistoryDTO;
    }


}
