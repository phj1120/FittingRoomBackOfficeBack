package org.plateer.fittingroombo.seller.mapper;

import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerFileDTO;
import org.plateer.fittingroombo.seller.dto.SellerRegisterDTO;

public interface SellerMapper {

    Long insertSeller(SellerRegisterDTO sellerRegisterDTO);

    Long insertSellerFile(SellerFileDTO sellerFileDTO);
}
