package org.plateer.fittingroombo.store.service;


import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.store.dto.ResultDTO;

public interface StoreService {

    ResultDTO getStoreList(Long seNo);

    Long insertRequestHistory(RequestHistoryDTO requestHistoryDTO);

    Long updateRequestHistory(RequestHistoryDTO updateHistoryObj);

    RequestHistoryDTO getRequestHistoryDetailSeller(Long rhNo);

}
