package org.plateer.fittingroombo.dress.mapper;

import org.plateer.fittingroombo.seller.dto.SellerDTO;

public interface DressMapper {

    SellerDTO getSellerProfile(Long seNo);

    Long updateSellerProfile(SellerDTO sellerDTO);
}
