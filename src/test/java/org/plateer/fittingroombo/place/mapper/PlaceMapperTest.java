package org.plateer.fittingroombo.place.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.plateer.fittingroombo.room.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@Log4j2
public class PlaceMapperTest {
    @Autowired
    PlaceMapper placeMapper;
    @Autowired
    RoomMapper roomMapper;

    // 장소제공자 리스트
    @Test
    void getPlcaeList() {
        List<PlaceDTO> dtoList = placeMapper.getPlaceList();
        log.info(dtoList);
    }

    // 특정 장소제공자
    @Test
    void getPlcae() {
        PlaceDTO placeDTO = placeMapper.getPlace(2L);
        log.info(placeDTO);
    }

    // 특정 장소제공자와 엮인 ROOM 정보 출력
    @Test
    void getPlaceRoomList() {
        List<PlaceRoomDTO> dtoList = placeMapper.getPlaceRoomList();
        log.info(dtoList);
    }

    // 장소제공자 ID 로 Room 정보 출력
    @Test
    void getPlaceRoom() {
        PlaceRoomDTO placeRoomDTO = placeMapper.getPlaceRoom(9L);
        log.info(placeRoomDTO);
    }

    // 회원가입
    @Test
    void insertPlace() {
        RoomDTO roomDTO = new RoomDTO("문정점", "주소-1", "주소-2", "081-1234");;
        roomMapper.insertRoom(roomDTO);

        PlaceDTO placeDTO = new PlaceDTO( "테스트사람3", "2023-02-01", "test05", "uuid04", "test03@gmail.con", "010-1434-1344", "영업중", roomDTO.getRNo());
        placeMapper.insertPlace(placeDTO);
    }

    // 장소 정보 업데이트
    @Test
    void updatePlaceInfo() {
        PlaceDTO placeDTO = new PlaceDTO(2L, UUID.randomUUID().toString(), "test@gmail.com", "010-2484-3213");
        placeMapper.updatePlaceInfo(placeDTO);
    }

    // 장소 정보 업데이트
    @Test
    void updatePlaceStatus() {
        PlaceDTO placeDTO = new PlaceDTO(2L, "영업");
        placeMapper.updatePlaceStatus(placeDTO);
    }

    @Test
    void getPlaceById() {
        PlaceDTO placeDTO = placeMapper.getPlaceById("testphj");

        log.info(placeDTO);
    }
}
