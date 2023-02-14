package org.plateer.fittingroombo.store.service;


import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.store.dto.ResultDTO;

public interface StoreService {

    ResultDTO getStoreList(Long seNo);

    Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);

    Long updateRequestHistorySeller(RequestHistoryDTO updateHistoryObj);

    RequestHistoryDTO getRequestHistoryDetailSeller(Long rhNo);

}
