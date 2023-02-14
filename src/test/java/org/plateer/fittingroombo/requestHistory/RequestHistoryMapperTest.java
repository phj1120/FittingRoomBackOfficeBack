package org.plateer.fittingroombo.requestHistory;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class RequestHistoryMapperTest {
    @Autowired
    RequestHistoryMapper requestHistoryMapper;


    @Test
    void insertRequestPlace() {
        RequestHistoryDTO requestHistoryDTO = new RequestHistoryDTO("대기", "가입", "집가고싶다", LocalDateTime.now(), 2L);
        requestHistoryMapper.insertRequestHistoryPlace(requestHistoryDTO);
    }

    @Test
    void updateRequestPlace() {
        RequestHistoryDTO requestHistoryDTO = new RequestHistoryDTO(20L, "탈퇴", "일이 힘들어서요", LocalDateTime.now().plusDays(1));
        requestHistoryMapper.updateRequestHistoryPlace(requestHistoryDTO);
    }
}
