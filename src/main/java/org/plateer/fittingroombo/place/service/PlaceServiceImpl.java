package org.plateer.fittingroombo.place.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.dto.PlaceRegisterDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.plateer.fittingroombo.room.mapper.RoomMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class PlaceServiceImpl implements PlaceService {
    private final PlaceMapper placeMapper;
    private final RoomMapper roomMapper;


    @Override
    public List<PlaceRoomDTO> getPlaceAllList() { return placeMapper.getPlaceAllList(); }

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

    @Override
    public Long insertPlace(PlaceRegisterDTO placeRegisterDTO) {
        placeRegisterDTO.setPmPassword(new BCryptPasswordEncoder().encode(placeRegisterDTO.getPmPassword()));
        placeRegisterDTO.setPmStatus("대기");

        roomMapper.insertRoom(placeRegisterDTO);
        placeMapper.insertPlace(placeRegisterDTO);
        placeMapper.insertPlaceFile(placeRegisterDTO.getRoomImages(), placeRegisterDTO.getRoNo());

        return placeRegisterDTO.getPmNo();
    }
}
