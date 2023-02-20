package org.plateer.fittingroombo.place.service;

import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;

import java.util.List;

public interface PlaceService {
    List<PlaceRoomDTO> getPlaceRoomList();

    PlaceRoomDTO getPlaceRoom(Long pmNo);

    Long updatePlaceInfo(PlaceDTO placeDTO);
}
