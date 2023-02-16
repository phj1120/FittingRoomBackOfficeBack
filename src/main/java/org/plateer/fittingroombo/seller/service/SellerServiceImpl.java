package org.plateer.fittingroombo.seller.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerFileDTO;
import org.plateer.fittingroombo.seller.dto.SellerRegisterDTO;
import org.plateer.fittingroombo.seller.mapper.SellerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class SellerServiceImpl implements SellerService{
    private final SellerMapper sellerMapper;
    @Override
    public Long insertSeller(SellerRegisterDTO sellerRegisterDTO) {
        sellerRegisterDTO.setSeCreateDt(LocalDateTime.now());
        sellerRegisterDTO.setSeStatus("대기");
        SellerFileDTO sellerFileDTO = sellerRegisterDTO.getSaveImage();
        sellerMapper.insertSeller(sellerRegisterDTO);
        log.info("======================================");
        log.info("======================================");
        log.info(sellerRegisterDTO);
        sellerFileDTO.setSeNo(sellerRegisterDTO.getSeNo());
        sellerMapper.insertSellerFile(sellerFileDTO);
        return sellerRegisterDTO.getSeNo();
    }
}
