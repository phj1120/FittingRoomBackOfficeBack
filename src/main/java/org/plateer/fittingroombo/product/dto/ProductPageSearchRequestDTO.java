package org.plateer.fittingroombo.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.plateer.fittingroombo.common.dto.PageRequestDTO;
import org.plateer.fittingroombo.product.dto.enums.ProductSearchType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductPageSearchRequestDTO extends PageRequestDTO {
    private List<ProductSearchType> types;
    private String keyword;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDt = LocalDate.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDt = LocalDate.now().minusYears(1L); // 1년 전부터 지금이 기본

    // 상품번호, 카테고리, 브랜드, 상품명, 이미지, 가격, 등록일, 수정일, 상태
    private ProductListOrder sort;

    private SortType sortType;

    public ProductPageSearchRequestDTO(int page, int size, List<ProductSearchType> types,
                                       String keyword, LocalDate startDt, LocalDate endDt) {
        super(page, size);
        this.types = types;
        this.keyword = keyword;
        this.startDt = startDt;
        this.endDt = endDt;
    }

    public ProductPageSearchRequestDTO(int page, int size, List<ProductSearchType> types, String keyword) {
        super(page, size);
        this.types = types;
        this.keyword = keyword;
        this.startDt = LocalDate.now().minusYears(1L);
        this.endDt = LocalDate.now();
    }


}
