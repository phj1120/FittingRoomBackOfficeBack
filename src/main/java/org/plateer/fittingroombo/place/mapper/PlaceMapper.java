package org.plateer.fittingroombo.place.mapper;


import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.plateer.fittingroombo.room.dto.RoomPageRequestDTO;

import java.util.List;


public interface PlaceMapper {
    List<PlaceDTO> getPlaceList();
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
