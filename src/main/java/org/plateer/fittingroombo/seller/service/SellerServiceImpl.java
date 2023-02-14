package org.plateer.fittingroombo.seller.service;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.mapper.SellerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService{
    private final SellerMapper sellerMapper;
    @Override
    public Long insertSeller(SellerDTO sellerDTO) {
        sellerDTO.setSeCreateDt(LocalDate.now());
        sellerDTO.setSeStatus("대기");
        sellerMapper.insertSeller(sellerDTO);
        return sellerDTO.getSeNo();
    }
}
