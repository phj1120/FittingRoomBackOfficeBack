package org.plateer.fittingroombo.seller.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.requestHistory.mapper.RequestHistoryMapper;
import org.plateer.fittingroombo.common.util.crawling.Crawling;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.dto.SellerRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class SellerMapperTest {
    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    RequestHistoryMapper requestHistoryMapper;

    @Autowired
    Crawling crawling;

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
//        List<RequestHistoryDTO> dtoList = requestHistoryMapper.getRoomSellerRequestHistoryAllList(requestHistoryPageRequestDTO);
        int total = requestHistoryMapper.getRoomSellerCount(requestHistoryPageRequestDTO);

//        PageResultDTO<RequestHistoryDTO> pageResultDTO = PageResultDTO.<RequestHistoryDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(requestHistoryPageRequestDTO).build();
//        log.info(pageResultDTO);
    }

    @Test
    void insertSeller() throws Exception {
        int[] pmNo = {26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47};
        List<String> sellerList = crawling.crawlingSeller();

        String[] nameFirst = {"김", "이", "박", "정", "최", "임", "주"};
        String[] nameMiddle = {"현", "수", "호", "승", "성", "우", "도"};
        String[] nameLast = {"현", "영", "윤", "승", "연", "아", "슬"};

        String[] emailFirst = {"mica", "dosia", "doeas", "wkosa", "testok"};
        String[] emailLast = {"13", "25", "90", "00", "54"};

        String[] phoneFirst = {"-1287", "-9546", "-8047", "-5567", "-5604"};
        String[] phoneLast = {"-2548", "-5726", "-9048", "-2482", "-1357"};

        String[] address = {"서울 마포구 양화로 지하 160", "서울 광진구 능동로 120", "서울 중구 을지로 지하 42", "서울 영등포구 경인로 701", "서울 영등포구 도영로 2-5"};
        IntStream.rangeClosed(0, sellerList.size()-1).forEach(i -> {
            String sellerId = emailLast[(int)(Math.random() * 5)] + emailFirst[(int)(Math.random() * 5)] + emailLast[(int)(Math.random() * 5)];
            SellerRegisterDTO sellerRegisterDTO = SellerRegisterDTO.builder()
                    .seName(sellerList.get(i))
                    .seManager(nameFirst[(int)(Math.random() * 7)] + nameMiddle[(int)(Math.random() * 7)] + nameLast[(int)(Math.random() * 7)])
                    .seId(sellerId)
                    .sePassword(new BCryptPasswordEncoder().encode("password"))
                    .seEmail(sellerId + "@gmail.com")
                    .sePhone("010" + phoneFirst[(int)(Math.random() * 5)] + phoneLast[(int)(Math.random() * 5)])
                    .seAddress(address[(int)(Math.random() * 5)])
                    .seStatus("영업")
                    .pmNo(new Long(pmNo[(int)(Math.random() * 22)]))
                    .build();
            sellerMapper.insertSeller(sellerRegisterDTO);
            System.out.println(sellerRegisterDTO);
        });


//        System.out.println(Arrays.toString(pmNo));
//        System.out.println((int)(Math.random() * 2) + 1);

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

    }
    
    @Test
    void name() {
        SellerDTO sellerById = sellerMapper.getSellerById("test001");

        log.info(sellerById);
    }
}
