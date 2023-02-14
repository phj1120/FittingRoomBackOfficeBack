package org.plateer.fittingroombo.seller.service;

import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerRegisterDTO;

public interface SellerService {
    Long insertSeller(SellerRegisterDTO sellerRegisterDTO);
}
