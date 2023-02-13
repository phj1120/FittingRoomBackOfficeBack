package org.plateer.fittingroombo.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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

    @Override
    public ResultDTO getStoreList(Long sNo) {
        List<SellerStatusDTO> resultList =  storeMapper.getStoreList(sNo);
        ResultDTO resultDTO = new ResultDTO(resultList, storeMapper.getStoreStatus(sNo));

        return resultDTO;
    }


}
