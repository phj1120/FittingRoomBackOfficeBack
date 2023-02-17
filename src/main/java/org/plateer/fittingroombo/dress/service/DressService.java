package org.plateer.fittingroombo.dress.service;

import org.plateer.fittingroombo.seller.dto.SellerDTO;

public interface DressService {

    SellerDTO getSellerProfile(Long seNo);

    Long updateSellerProfile(SellerDTO sellerDTO);
}
