package org.plateer.fittingroombo.seller.mapper;


import org.plateer.fittingroombo.seller.dto.SellerDTO;

import java.util.List;

public interface SellerMapper {
    // 특정 장소제공자의 입점한 판매자 리스트 출력
    List<SellerDTO> getSellerList(Long pmNo);

    // 특정 판매자 조회
    SellerDTO getSeller(Long seNo);

//    int getCount(RollingPageRequestDTO rollingPageRequestDTO);
//
//    List<RollingDTO> getList(RollingPageRequestDTO rollingPageRequestDTO);
//
//    RollingDTO getRolling(Long id);
//
//    int addRolling(RollingDTO rollingDTO);
//
//    int modifyRolling(RollingDTO rollingDTO);
//
//    int deleteRolling(Long rollingId);
}
