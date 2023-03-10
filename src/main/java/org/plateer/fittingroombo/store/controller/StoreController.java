package org.plateer.fittingroombo.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.security.dto.CustomUserDetail;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.store.service.StoreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    //판매자가 신청한 hostory request list 불러오기
    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("/status")
    public PageResultDTO<RequestHistoryDTO> getStoreList(
            @AuthenticationPrincipal CustomUserDetail user,RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {

        requestHistoryPageRequestDTO.setId(user.getUserNo());
        return storeService.getStoreList(requestHistoryPageRequestDTO);
    }

    //판매자 상태현황 상태 가져오기(영업중,휴업중)
    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("/status/info")
    public ResultDTO<SellerDTO> getStoreStatus(@AuthenticationPrincipal CustomUserDetail user) {

     return  ResultDTO.<SellerDTO>builder()
                .data(storeService.getStoreStatus(user.getUserNo())).build();
    }

    //판매자 영업 상태 변경 수정 (대기중 인 건만 가능)
    @PreAuthorize("hasRole('SELLER')")
    @PutMapping("/status")
    public ResultDTO<Long> updateRequestHistorySeller(@RequestBody RequestHistoryDTO requestHistoryDTO) {

        return ResultDTO.<Long>builder()
                .data(storeService.updateRequestHistorySeller(requestHistoryDTO)).build();
    }

    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("/status/detail/{id}")
    public ResultDTO<RequestHistoryDTO> getRequestHistoryDetail(@PathVariable("id") Long rhNo){

      return  ResultDTO.<RequestHistoryDTO>builder()
                .data(storeService.getRequestHistoryDetailSeller(rhNo)).build();
    }

    //판매자 영상 상태 변경 시청
    @PostMapping("/request")
    public ResultDTO<Long> insertRequestHistorySeller(@RequestBody RequestHistoryDTO requestHistoryDTO) {

        requestHistoryDTO.setSeNo(requestHistoryDTO.getSeNo());
        return ResultDTO.<Long>builder()
                .data(storeService.insertRequestHistorySeller(requestHistoryDTO)).build();
    }

    //판매자 영상 상태 변경 시청
    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/modify")
    public ResultDTO<Long> modifyRequestHistorySeller(@AuthenticationPrincipal CustomUserDetail user
    ,@RequestBody RequestHistoryDTO requestHistoryDTO) {

        requestHistoryDTO.setSeNo(user.getUserNo());
        return ResultDTO.<Long>builder()
                .data(storeService.modifyRequestHistorySeller(requestHistoryDTO)).build();
    }


}
