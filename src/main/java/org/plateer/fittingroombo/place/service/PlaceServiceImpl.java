package org.plateer.fittingroombo.place.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class PlaceServiceImpl implements PlaceService {
    private final PlaceMapper placeMapper;

    @Override
    public List<PlaceRoomDTO> getPlaceRoomList() {
        return placeMapper.getPlaceRoomList();
    }

    @Override
    public PlaceRoomDTO getPlaceRoom(Long pmNo) {
        return placeMapper.getPlaceRoom(pmNo);
    }

    @Override
    public Long updatePlaceInfo(PlaceDTO placeDTO) {
        placeMapper.updatePlaceInfo(placeDTO);
        return placeDTO.getPmNo();
    }
}
