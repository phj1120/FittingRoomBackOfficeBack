package org.plateer.fittingroombo.dress.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.dress.mapper.DressMapper;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class DressServiceImpl implements DressService{
    private final DressMapper dressMapper;
    @Override
    public SellerDTO getSellerProfile(Long seNo) {
        return dressMapper.getSellerProfile(seNo);
    }

    @Override
    public Long updateSellerProfile(SellerDTO sellerDTO) {
        return dressMapper.updateSellerProfile(sellerDTO);
    }
}
