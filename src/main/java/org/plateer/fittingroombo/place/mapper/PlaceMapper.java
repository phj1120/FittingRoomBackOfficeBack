package org.plateer.fittingroombo.place.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.plateer.fittingroombo.room.dto.RoomPageRequestDTO;

import java.util.List;


@Mapper
public interface PlaceMapper {
    // 장소제공자 리스트 ( 탈퇴 아닌경우 )
    List<PlaceDTO> getPlaceList();

    // 장소제공자 아이디로 정보 얻어오기
    PlaceDTO getPlace( Long pmNo );
    
    // 장소제공자 회원가입
    void insertPlace( PlaceDTO placeDTO );
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
