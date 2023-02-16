package org.plateer.fittingroombo.room.mapper;


import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.plateer.fittingroombo.room.dto.RoomPageRequestDTO;


import java.util.List;


public interface RoomMapper {
    void insertRoom(RoomDTO roomDTO);

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
