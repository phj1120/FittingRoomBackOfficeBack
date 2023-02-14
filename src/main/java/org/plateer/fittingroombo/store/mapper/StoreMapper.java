package org.plateer.fittingroombo.store.mapper;

import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.store.dto.SellerStatusDTO;

import java.util.List;

public interface StoreMapper {

    List<SellerStatusDTO> getStoreList(Long seNo);

    String getStoreStatus(Long seNo);


}
