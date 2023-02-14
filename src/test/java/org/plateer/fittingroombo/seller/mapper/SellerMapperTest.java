package org.plateer.fittingroombo.seller.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class SellerMapperTest {
    @Autowired
    SellerMapper sellerMapper;

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
}
