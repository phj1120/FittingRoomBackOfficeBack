package org.plateer.fittingroombo.store.mapper;

import org.plateer.fittingroombo.store.dto.SellerStatusDTO;

import java.util.List;

public interface StoreMapper {

    List<SellerStatusDTO> getStoreList(Long sNo);

    String getStoreStatus(Long sNo);
}
