package org.plateer.fittingroombo.seller.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerRequestDTO;
import org.plateer.fittingroombo.seller.service.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/seller")
public class SellerController {
    private final SellerService sellerService;

    // 대기중인 판매자 요청 현황
    @GetMapping("status")
    public PageResultDTO<SellerRequestDTO> getRoomSellerStatus(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        return sellerService.getRoomSellerStatus(requestHistoryPageRequestDTO);
    }

    // 장소자에게 입점한 판매자 목록
    @GetMapping("list")
    public PageResultDTO<SellerDTO> getPlaceSellerList(SellerPageRequestDTO sellerPageRequestDTO) {
        return sellerService.getPlaceSellerList(sellerPageRequestDTO);
    }

    // 장소제공자에게 요청한 요청 기록
    @GetMapping("history")
    public PageResultDTO<RequestHistoryDTO> getRoomSellerHistory(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        return sellerService.getRoomSellerHistory(requestHistoryPageRequestDTO);
    }

    // Status 목록 구하기
    @GetMapping("statusTypeList")
    public List<SellerDTO> getStatusTypeList() {
        return sellerService.getStatusTypeList();
    }

    // Seller Request 응답하기
    @PostMapping("answer")
    public ResultDTO<Long> insertRequestHistorySeller(@RequestBody RequestHistoryDTO requestHistoryDTO) {
        Long rhNo = sellerService.insertRequestHistorySeller(requestHistoryDTO);
        return ResultDTO.<Long>builder().data(rhNo).build();
    }
}
