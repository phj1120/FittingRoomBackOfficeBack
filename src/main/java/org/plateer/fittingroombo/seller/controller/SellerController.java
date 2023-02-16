package org.plateer.fittingroombo.seller.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.util.ImageUtil;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerFileDTO;
import org.plateer.fittingroombo.seller.dto.SellerRegisterDTO;
import org.plateer.fittingroombo.seller.service.SellerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/seller")
public class SellerController {
    private final SellerService sellerService;
    private final ImageUtil imageUtil;


    @PostMapping("/register")
    public ResultDTO<Long> insertSeller( SellerRegisterDTO sellerRegisterDTO){
        log.info(sellerRegisterDTO);
        SellerFileDTO sellerFileDTO = imageUtil.saveBizImage(sellerRegisterDTO.getImage());
        sellerRegisterDTO.setSaveImage(sellerFileDTO);

        return ResultDTO.<Long>builder().data(sellerService.insertSeller(sellerRegisterDTO)).build();
    }

}
