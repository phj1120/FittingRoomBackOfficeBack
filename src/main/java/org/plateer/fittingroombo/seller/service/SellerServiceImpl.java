package org.plateer.fittingroombo.seller.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.seller.dto.*;
import org.plateer.fittingroombo.seller.mapper.SellerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 판매자 service
 * 작성자 : 주호승
 * 일시 : 2023-02-17
 * 버전 : v1
 **/
@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class SellerServiceImpl implements SellerService {
    private final SellerMapper sellerMapper;
    private final RequestHistoryMapper requestHistoryMapper;

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
    public SellerProfileDTO getProfileSeller(Long seNo) {
        return sellerMapper.getProfileSeller(seNo);
    }

    @Override
    public Long modifyProfileSeller(SellerDTO sellerDTO) {
        return sellerMapper.modifyProfileSeller(sellerDTO);
    }

    @Override
    public List<SellerDTO> getStatusTypeList() {
        return sellerMapper.getStatusTypeList();
    }

    @Override
    public Long insertRequestHistorySeller(RequestHistoryDTO requestHistoryDTO) {
        requestHistoryMapper.insertRequestHistorySeller(requestHistoryDTO);
        sellerMapper.updateSellerStatus(requestHistoryDTO);

        return requestHistoryDTO.getRhNo();
    }

    @Override
    public Long insertSeller(SellerRegisterDTO sellerRegisterDTO) {
        sellerRegisterDTO.setSeStatus("대기");
        SellerFileDTO sellerFileDTO = sellerRegisterDTO.getSaveImage();
        sellerMapper.insertSeller(sellerRegisterDTO);
        sellerFileDTO.setSeNo(sellerRegisterDTO.getSeNo());
        sellerMapper.insertSellerFile(sellerFileDTO);
        return sellerRegisterDTO.getSeNo();
    }
}
