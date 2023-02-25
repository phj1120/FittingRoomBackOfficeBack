package org.plateer.fittingroombo.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDTO {

    private Long cpNo; // 장바구니 상품 번호

    private LocalDateTime cpCreateDt; // 장바구니 상품 등록일

    private Boolean cpStatus; // 장바구니 상품 상태

    private Long caNo; // 장바구니 번호

    private Long spNo; // 판매 상품 번호

    private String prName; // 상품명

    private String prBrand; // 상품 브랜드

    private String spSize; // 판매 상품 사이즈

    private Long prPrice; // 상품 가격

    private String thumbnail; // 상품 썸네일



}