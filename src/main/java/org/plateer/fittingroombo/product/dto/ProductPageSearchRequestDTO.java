package org.plateer.fittingroombo.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductPageSearchRequestDTO {
    private int page = 1;
    private int size = 10;
    private List<ProductSearchType> types;
    private String keyword;
    private LocalDate startDt = LocalDate.now().minusYears(1L); // 1년 전부터 지금이 기본
    private LocalDate endDt = LocalDate.now();

//    private SellProductStatus sort;

    public int getSkip() {
        return (page - 1) * size;
    }

    @Builder
    public ProductPageSearchRequestDTO(int page, int size, List<ProductSearchType> types, String keyword, LocalDate startDt, LocalDate endDt) {
        this.page = page;
        this.size = size;
        this.types = types;
        this.keyword = keyword;
        this.startDt = startDt;
        this.endDt = endDt;
    }
}
