package org.plateer.fittingroombo.Seller.Service;


import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
public class StoreServiceTest {

    @Autowired
    private RequestHistoryMapper requestHistoryMapper;
    @Test
    public void testInserts() {
        IntStream.rangeClosed(1, 2).forEach((i) -> {

          /* *//* Todo todo = Todo.builder()
                    .title("Title.."+i)
                    .writer("user"+i)
                    .dueDate(LocalDate.now().plusDays( i % 5 ))
                    .build();

            log.info(todoRepository.save(todo));*//*
            RequestHistoryDTO requestHistoryDTO = RequestHistoryDTO.builder()
                    .rhStatus("대기")
                    .rhContent("가입").rhReason("requestHistory+++" + i)
                    .rhCreateDt(LocalDate.now()).rhStartDt("2023-02-12")
                    .pmNo(null)
                    .sNo((long) 1)
                    .build();
            requestHistoryMapper.insertRequestHistory(requestHistoryDTO);*/
        });//end loop
    }
}
