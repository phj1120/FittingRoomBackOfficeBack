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
    private LocalDate prCreateDt;
    private LocalDate prModifyDt;
    private List<ProductFileDTO> files = new ArrayList<>();
    private List<ProductOptionDTO> options = new ArrayList<>();
    private Long pcNo; // 상품 카테고리 아이디
}
