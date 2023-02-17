package org.plateer.fittingroombo.store.mapper;

import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.seller.dto.SellerDTO;

import java.util.List;

public interface StoreMapper {

    SellerDTO getStoreStatus(Long seNo);


}
