package org.plateer.fittingroombo.seller.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.security.dto.CustomUserDetail;
import org.plateer.fittingroombo.common.util.ImageUtil;
import org.plateer.fittingroombo.seller.dto.*;
import org.plateer.fittingroombo.seller.service.SellerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 판매자 Controller
 * 작성자 : 주호승, 정승현
 * 일시 : 2023-02-17
 * 버전 : v2
 **/
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/seller")
public class SellerController {

    private final SellerService sellerService;
    private final ImageUtil imageUtil;

    //판매자 회원가입
    @PostMapping("/register")
    public ResultDTO<Long> insertSeller(SellerRegisterDTO sellerRegisterDTO){
        log.info(sellerRegisterDTO);
        SellerFileDTO sellerFileDTO = imageUtil.saveBizImage(sellerRegisterDTO.getImage());
        sellerRegisterDTO.setSaveImage(sellerFileDTO);

        return ResultDTO.<Long>builder().data(sellerService.insertSeller(sellerRegisterDTO)).build();
    }

    // 대기중인 판매자 요청 현황
    @PreAuthorize("hasRole('PLACE')")
    @GetMapping("status")
    public PageResultDTO<SellerRequestDTO> getRoomSellerStatus(@AuthenticationPrincipal CustomUserDetail user, RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        requestHistoryPageRequestDTO.setId(user.getUserNo());
        return sellerService.getRoomSellerStatus(requestHistoryPageRequestDTO);
    }

    // 장소자에게 입점한 판매자 목록
    @PreAuthorize("hasRole('PLACE')")
    @GetMapping("list")
    public PageResultDTO<SellerDTO> getPlaceSellerList(@AuthenticationPrincipal CustomUserDetail user, SellerPageRequestDTO sellerPageRequestDTO) {
        sellerPageRequestDTO.setId(user.getUserNo());
        return sellerService.getPlaceSellerList(sellerPageRequestDTO);
    }

    // 장소제공자에게 요청한 요청 기록 ( 판매자 요청 기록 메뉴 )
    @PreAuthorize("hasRole('PLACE')")
    @GetMapping("history")
    public PageResultDTO<SellerRequestDTO> getRoomSellerHistory(@AuthenticationPrincipal CustomUserDetail user, RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        requestHistoryPageRequestDTO.setId(user.getUserNo());
        return sellerService.getRoomSellerHistory(requestHistoryPageRequestDTO);
    }

    // Status 목록 구하기
    @GetMapping("statusTypeList")
    public List<SellerDTO> getStatusTypeList() {
        return sellerService.getStatusTypeList();
    }

    // Seller Request 응답하기
    @PreAuthorize("hasRole('PLACE')")
    @PostMapping("answer")
    public ResultDTO<Long> insertRequestHistorySeller(@RequestBody RequestHistoryDTO requestHistoryDTO) {
        Long rhNo = sellerService.insertRequestHistorySeller(requestHistoryDTO);
        return ResultDTO.<Long>builder().data(rhNo).build();
    }

    // Status 목록 구하기
    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("profile")
    public ResultDTO<SellerProfileDTO> getProfileSeller(@AuthenticationPrincipal CustomUserDetail user) {
        return ResultDTO.<SellerProfileDTO>builder().data(sellerService.getProfileSeller(user.getUserNo())).build();
    }

    @PreAuthorize("hasRole('SELLER')")
    @PutMapping("profile")
    public ResultDTO<Long> modifyProfileSeller(@RequestBody SellerDTO sellerDTO) {
        return ResultDTO.<Long>builder().data(sellerService.modifyProfileSeller(sellerDTO)).build();
    }


}
