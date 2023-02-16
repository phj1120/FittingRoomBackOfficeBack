package org.plateer.fittingroombo.seller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.fittingroombo.common.dto.PageRequestDTO;


@Data
@NoArgsConstructor
public class SellerPageRequestDTO extends PageRequestDTO {
    Long id;
    SellerStatusType[] status;
    SellerSearchType[] type;
    String keyword;

    public SellerPageRequestDTO(int page, int size ) { super( page, size ); }

    public SellerPageRequestDTO(int page, int size, Long id, SellerSearchType[] type, String keyword) {
        super( page, size );
        this.id = id;
        this.type = type;
        this.keyword = keyword;
    }

    public SellerPageRequestDTO(Long id, SellerSearchType[] type, String keyword) {
        this.id = id;
        this.type = type;
        this.keyword = keyword;
    }
}
