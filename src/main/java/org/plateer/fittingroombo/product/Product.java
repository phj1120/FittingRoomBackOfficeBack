package org.plateer.fittingroombo.product;

import java.time.LocalDate;

public class Product {
    private Long prNo;
    private String prBrand;
    private String prName;
    private Long prPrice;
    private String prThumbnail;
    private LocalDate prCreate_dt;
    private LocalDate prModify_dt;
    private Long gcNo; // 상품 카테고리 아이디
}