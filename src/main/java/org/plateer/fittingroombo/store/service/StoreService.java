package org.plateer.fittingroombo.store.service;


import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerDTO;

public interface StoreService {

    PageResultDTO<RequestHistoryDTO> getStoreList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    SellerDTO getStoreStatus(Long seNo);

    Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);

    Long modifyRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);

    Long updateRequestHistorySeller(RequestHistoryDTO updateHistoryObj);

    RequestHistoryDTO getRequestHistoryDetailSeller(Long rhNo);

}
