package org.plateer.fittingroombo.room.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class RoomMapperTest {
    @Autowired
    RoomMapper roomMapper;

    @Test
    void insertRoom() {
        RoomDTO roomDTO = new RoomDTO("홍대점", "주소-1", "주소-2", "080-1234");
        roomMapper.insertRoom(roomDTO);
    }
}
