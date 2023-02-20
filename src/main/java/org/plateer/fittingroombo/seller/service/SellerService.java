package org.plateer.fittingroombo.seller.service;

import org.plateer.fittingroombo.seller.dto.*;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerDTO;

import java.util.List;

public interface SellerService {

    Long insertSeller(SellerRegisterDTO sellerRegisterDTO);
    
    PageResultDTO<SellerRequestDTO> getRoomSellerStatus(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    PageResultDTO<SellerRequestDTO> getRoomSellerHistory(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO);

    PageResultDTO<SellerDTO> getPlaceSellerList(SellerPageRequestDTO sellerPageRequestDTO);

    SellerProfileDTO getProfileSeller(Long seNo);

    Long modifyProfileSeller(SellerDTO sellerDTO);

    List<SellerDTO> getStatusTypeList();

    Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO);


}
