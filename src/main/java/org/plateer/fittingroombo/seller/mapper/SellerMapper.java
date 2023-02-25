package org.plateer.fittingroombo.seller.mapper;

import org.plateer.fittingroombo.seller.dto.*;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.seller.dto.SellerDTO;

import java.util.List;

public interface SellerMapper {
    Long insertSellerFile(SellerFileDTO sellerFileDTO);

    // 장소제고자에게 입점한 판매자 총 개수 구하기
    int getCount( SellerPageRequestDTO sellerPageRequestDTO );

    List<SellerDTO> getStatusTypeList();

    // 장소제고자에게 입점한 판매자 목록
    List<SellerDTO> getPlaceSellerList( SellerPageRequestDTO sellerPageRequestDTO );

    // 특정 장소제공자의 입점한 판매자 리스트 출력
    List<SellerDTO> getSellerList( Long pmNo );

    // 특정 판매자 조회
    SellerDTO getSeller( Long seNo );

    //판매자 프로필 조회
    SellerProfileDTO getProfileSeller(Long seNo );

    //판매자 프로필 수정
    Long modifyProfileSeller(SellerDTO sellerDTO);

     Long insertSeller(SellerRegisterDTO sellerRegisterDTO);

    SellerDTO getSellerById( String memberId );
    
    Long updateSellerStatus(RequestHistoryDTO requestHistoryDTO);
}
