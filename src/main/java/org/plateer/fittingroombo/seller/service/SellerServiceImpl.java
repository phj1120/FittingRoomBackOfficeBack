package org.plateer.fittingroombo.seller.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerRequestDTO;
import org.plateer.fittingroombo.seller.mapper.SellerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class SellerServiceImpl implements SellerService {
    private final RequestHistoryMapper requestHistoryMapper;
    private final SellerMapper sellerMapper;

    @Override
    public PageResultDTO<SellerRequestDTO> getRoomSellerStatus(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        List<SellerRequestDTO> dtoList = requestHistoryMapper.getRoomSellerRequestHistoryList(requestHistoryPageRequestDTO);
        int total = requestHistoryMapper.getSellerRequestCount(requestHistoryPageRequestDTO);

        PageResultDTO<SellerRequestDTO> pageResultDTO = PageResultDTO.<SellerRequestDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(requestHistoryPageRequestDTO).build();
        return pageResultDTO;
    }

    @Override
    public PageResultDTO<RequestHistoryDTO> getRoomSellerHistory(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getRoomSellerRequestHistoryAllList(requestHistoryPageRequestDTO);
        int total = requestHistoryMapper.getRoomSellerCount(requestHistoryPageRequestDTO);

        PageResultDTO<RequestHistoryDTO> pageResultDTO = PageResultDTO.<RequestHistoryDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(requestHistoryPageRequestDTO).build();
        return pageResultDTO;
    }

    @Override
    public PageResultDTO<SellerDTO> getPlaceSellerList(SellerPageRequestDTO sellerPageRequestDTO) {
        List<SellerDTO> dtoList = sellerMapper.getPlaceSellerList(sellerPageRequestDTO);
        int total = sellerMapper.getCount(sellerPageRequestDTO);

        PageResultDTO pageResultDTO = PageResultDTO.<SellerDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(sellerPageRequestDTO).build();
        return pageResultDTO;
    }

    @Override
    public List<SellerDTO> getStatusTypeList() {
        return sellerMapper.getStatusTypeList();
    }
}
