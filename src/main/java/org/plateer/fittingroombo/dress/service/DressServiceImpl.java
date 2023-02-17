package org.plateer.fittingroombo.dress.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.dress.mapper.DressMapper;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 판매자 프로필 service
 * 작성자 : 주호승
 * 일시 : 2023-02-17
 * 버전 : v1
 **/
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
