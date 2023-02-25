package org.plateer.fittingroombo.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long caNo; // 장바구니 번호

    private LocalDateTime caCreateDt; // 장바구니 생성일

    private LocalDateTime caModifyDt; // 장바구니 수정일

    private Long roNo; // 장소 번호

    private Long coNo; // 구매자 번호
    
    private String rfUuid; // 장소 이미지
    
    private String roName; // 장소명
    
    private Long countProduct; // 장바구니 상품 수
    
    private Long totalPrice; // 총 가격

}