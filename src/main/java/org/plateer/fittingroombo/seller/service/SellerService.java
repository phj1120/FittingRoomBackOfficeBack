package org.plateer.fittingroombo.seller.service;

import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerRequestDTO;

import java.util.List;

public interface SellerService {
    PageResultDTO<SellerRequestDTO> getRoomSellerStatus(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    PageResultDTO<RequestHistoryDTO> getRoomSellerHistory(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    PageResultDTO<SellerDTO> getPlaceSellerList(SellerPageRequestDTO sellerPageRequestDTO);

    List<SellerDTO> getStatusTypeList();

    Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);
}
