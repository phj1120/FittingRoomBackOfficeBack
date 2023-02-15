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
        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getRoomSellerRequestHistoryList(requestHistoryDTO);
        log.info(dtoList);
    }

    @Test
    void getRoomSellerRequestAllList() {
        RequestHistoryPageRequestDTO requestHistoryPageRequestDTO = new RequestHistoryPageRequestDTO(2L);
        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getRoomSellerRequestHistoryAllList(requestHistoryPageRequestDTO);
        int total = requestHistoryMapper.getRoomSellerCount(requestHistoryPageRequestDTO);

        PageResultDTO<RequestHistoryDTO> pageResultDTO = PageResultDTO.<RequestHistoryDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(requestHistoryPageRequestDTO).build();
        log.info(pageResultDTO);
    }
}
