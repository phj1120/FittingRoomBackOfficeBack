package org.plateer.fittingroombo.place.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.plateer.fittingroombo.product.dto.enums.ProductFileType;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlaceFileDTO {
    private Long rfNo;

    private String rfName;
    private String rfUuid;
    private Boolean rfThumbnail;

    private Long roNo;


    public PlaceFileDTO( String rfName, String rfUuid ) {
        this.rfName = rfName;
        this.rfUuid = rfUuid;
    }
}
