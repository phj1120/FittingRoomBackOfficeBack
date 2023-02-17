package org.plateer.fittingroombo.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.store.service.StoreService;
import org.springframework.web.bind.annotation.*;


/**
 * 영업관리 controller
 * 작성자 : 주호승
 * 일시 : 2023-02-17
 * 버전 : v1
 **/
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/seller/store")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/status")
    public PageResultDTO<RequestHistoryDTO> getStoreList( RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        return storeService.getStoreList(requestHistoryPageRequestDTO);
    }

    @GetMapping("/status/{id}")
    public ResultDTO<SellerDTO> getStoreStatus(@PathVariable("id") Long seNo) {

     return  ResultDTO.<SellerDTO>builder()
                .data(storeService.getStoreStatus(seNo)).build();
    }

    @PutMapping("/status")
    public ResultDTO<Long> updateRequestHistorySeller(@RequestBody RequestHistoryDTO requestHistoryDTO) {
        log.info("=====================================");
        log.info("=====================================");
        log.info("=====================================");
        log.info(requestHistoryDTO);
        return ResultDTO.<Long>builder()
                .data(storeService.updateRequestHistorySeller(requestHistoryDTO)).build();
    }

    @GetMapping("/status/detail/{id}")
    public ResultDTO<RequestHistoryDTO> getRequestHistoryDetail(@PathVariable("id") Long rhNo){

      return  ResultDTO.<RequestHistoryDTO>builder()
                .data(storeService.getRequestHistoryDetailSeller(rhNo)).build();
    }

    @PostMapping("/request")
    public ResultDTO<Long> insertRequestHistorySeller(@RequestBody RequestHistoryDTO requestHistoryDTO) {


        return ResultDTO.<Long>builder()
                .data(storeService.insertRequestHistorySeller(requestHistoryDTO)).build();
    }


}
