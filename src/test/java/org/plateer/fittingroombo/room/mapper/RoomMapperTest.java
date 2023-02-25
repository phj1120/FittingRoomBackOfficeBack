package org.plateer.fittingroombo.room.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.common.util.crawling.Crawling;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.plateer.fittingroombo.room.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class RoomMapperTest {
//    @Autowired
//    RoomMapper roomMapper;
    @Autowired
    Crawling crawling;


    @Test
    void roomCrawling() throws Exception {
        crawling.crawlingRoom();
    }

    @Test
    void insertRoom() {
//        RoomDTO roomDTO = new RoomDTO("홍대점", "주소-1", "주소-2", "080-1234");
//        roomMapper.insertRoom(roomDTO);
    }

//    @Test
//    void crawling() throws Exception {
//        crawling.placeCrawling("C:\\upload\\test", "https://www.musinsa.com/categories/item/001006?d_cat_cd=001006&brand=&list_kind=big&sort=pop_category&sub_sort=&page=1&display_cnt=90&group_sale=&exclusive_yn=&sale_goods=&timesale_yn=&ex_soldout=&kids=&color=&price1=&price2=&shoeSizeOption=&tags=&campaign_id=&includeKeywords=&measure=");
//    }
}
