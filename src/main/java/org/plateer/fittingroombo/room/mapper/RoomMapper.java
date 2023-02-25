package org.plateer.fittingroombo.room.mapper;


import org.plateer.fittingroombo.place.dto.PlaceRegisterDTO;
import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.plateer.fittingroombo.room.dto.RoomPageRequestDTO;


import java.util.List;


public interface RoomMapper {
    // Room 생성 후 마지막 Insert ID 반환
    void insertRoom(PlaceRegisterDTO placeRegisterDTO);

    List<RoomDTO> getRoomList(RoomPageRequestDTO roomPageRequestDTO);
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
