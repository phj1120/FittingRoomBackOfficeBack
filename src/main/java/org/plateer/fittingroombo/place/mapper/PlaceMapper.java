package org.plateer.fittingroombo.place.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.dto.PlaceFileDTO;
import org.plateer.fittingroombo.place.dto.PlaceRegisterDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.plateer.fittingroombo.room.dto.RoomPageRequestDTO;

import java.util.List;


@Mapper
public interface PlaceMapper {
    // 장소제공자 리스트 ( 탈퇴 아닌경우 )
    List<PlaceDTO> getPlaceList();

    // 장소제공자 아이디로 정보 얻어오기
    PlaceDTO getPlace( Long pmNo );

    // 장소 제공자 아이디로 정보 얻어오기
    PlaceDTO getPlaceById( String memberId );

    // 장소제공자 회원가입
    void insertPlace(PlaceRegisterDTO placeRegisterDTO);

    // 장소제공자 정보 수정
    void updatePlaceInfo( PlaceDTO placeDTO );

    // 장소제공자 상태 수정
    void updatePlaceStatus( PlaceDTO placeDTO );


    // 장소제공자를 통한 ROOM List ( 탈퇴 아닌 경우 )
    List<PlaceRoomDTO> getPlaceRoomList();

    // 장소제공자를 통한 특정 ROOM 정보 ( 탈퇴 아닌 경우 )
    PlaceRoomDTO getPlaceRoom( Long pmNo );

    void insertPlaceFile(List<PlaceFileDTO> placeFileDTOList, Long roNo);
}
