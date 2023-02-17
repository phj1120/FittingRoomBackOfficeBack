package org.plateer.fittingroombo.seller.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class SellerMapperTest {
    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    RequestHistoryMapper requestHistoryMapper;

    @Test
    void getSellerList() {
        List<SellerDTO> dtoList = sellerMapper.getSellerList(1L);
        log.info(dtoList);
    }

    @Test
    void getSeller() {
        SellerDTO sellerDTO = sellerMapper.getSeller(1L);
        log.info(sellerDTO);
    }

    @Test
    void getRoomSellerRequestList() {
        RequestHistoryDTO requestHistoryDTO = new RequestHistoryDTO(2L);
//        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getRoomSellerRequestHistoryList(requestHistoryDTO);
//        log.info(dtoList);
    }

    @Test
    void getRoomSellerRequestAllList() {
        RequestHistoryPageRequestDTO requestHistoryPageRequestDTO = new RequestHistoryPageRequestDTO(2L);
        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getRoomSellerRequestHistoryAllList(requestHistoryPageRequestDTO);
        int total = requestHistoryMapper.getRoomSellerCount(requestHistoryPageRequestDTO);

        PageResultDTO<RequestHistoryDTO> pageResultDTO = PageResultDTO.<RequestHistoryDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(requestHistoryPageRequestDTO).build();
        log.info(pageResultDTO);
    }

//    @Test
//    void insertSeller() {
//        IntStream.rangeClosed(91, 120).forEach(i -> {
//            SellerDTO sellerDTO = SellerDTO.builder()
//                    .seName("이이이" + i)
//                    .seManager("주정현수" + i)
//                    .seId("test00" + i)
//                    .sePassword(UUID.randomUUID().toString())
//                    .seEmail("test00" + i + "@plateer.com")
//                    .sePhone("010-1234-5678")
//                    .seAddress("서울시 관악구 봉천동")
//                    .seStatus("휴업")
//                    .pmNo(new Long(((int)(Math.random() * 2) + 1)))
//                    .build();
//            sellerMapper.insertSeller(sellerDTO);
//        });
//
//    }
    
    @Test
    void name() {
        SellerDTO sellerById = sellerMapper.getSellerById("test001");

        log.info(sellerById);
    }
}
