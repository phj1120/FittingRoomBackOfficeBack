package org.plateer.fittingroombo.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.store.dto.SellerStatusDTO;
import org.plateer.fittingroombo.store.dto.ResultDTO;
import org.plateer.fittingroombo.store.mapper.StoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;
    private final RequestHistoryMapper requestHistoryMapper;

    @Override
    public ResultDTO getStoreList(Long seNo) {
        List<SellerStatusDTO> resultList = storeMapper.getStoreList(seNo);
        ResultDTO resultDTO = new ResultDTO(resultList, storeMapper.getStoreStatus(seNo));

        return resultDTO;
    }

    @Override
    public Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO) {

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
