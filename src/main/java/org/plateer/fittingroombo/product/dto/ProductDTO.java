package org.plateer.fittingroombo.product.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
    private Long prNo;
    private String prBrand;
    private String prName;
    private Long prPrice;
    private String prThumbnail;
    private Long prcNo; // 상품 카테고리 아이디
    private LocalDate prCreateDt;
    private LocalDate prModifyDt;
    private List<ProductFileDTO> files = new ArrayList<>();
    private List<SellProductDTO> options = new ArrayList<>();
    private Long pcNo; // 상품 카테고리 아이디
}
