package org.plateer.fittingroombo.place.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class PlaceMapperTest {
    @Autowired
    PlaceMapper placeMapper;

    @Test
    void getPlcaeList() {
        List<PlaceDTO> dtoList = placeMapper.getPlaceList();
        log.info(dtoList);
    }

    @Test
    void getPlcae() {
        PlaceDTO placeDTO = placeMapper.getPlace(2L);
        log.info(placeDTO);
    }

    @Test
    void insertPlace() {
        PlaceDTO placeDTO = new PlaceDTO( "테스트사람2", "2023-01-01", "test02", "uuid02", "test02@gmail.con", "010-1234-1344", "영업중", 32L);
        placeMapper.insertPlace(placeDTO);
    }
}
