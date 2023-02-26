package org.plateer.fittingroombo.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetReservationItemListDTO {

    private Long caNo;

    private Long seNo;

    private Long reNo;

    private Long cpNo;

    private Long orNo;
}
