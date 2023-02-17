package org.plateer.fittingroombo.dress.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.dress.service.DressService;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 판매자 프로필 controller
 * 작성자 : 주호승
 * 일시 : 2023-02-17
 * 버전 : v1
 **/
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/seller/dress")
public class DressController {
    private final DressService dressService;
    @GetMapping("/profile/{id}")
    public ResultDTO< SellerDTO> getSellerProfile(@PathVariable("id") Long seNo){

        return ResultDTO.<SellerDTO>builder().data(dressService.getSellerProfile(seNo)).build();
    }

    @PutMapping("/profile/{id}")
    public ResultDTO<Long> updateSellerProfile(@PathVariable("id") Long seNo, @RequestBody SellerDTO sellerDTO){

        sellerDTO.setSeNo(seNo);
        return ResultDTO.<Long>builder().data(dressService.updateSellerProfile(sellerDTO)).build();
    }
}
