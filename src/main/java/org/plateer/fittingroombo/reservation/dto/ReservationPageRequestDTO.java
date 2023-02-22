package org.plateer.fittingroombo.reservation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.fittingroombo.common.dto.PageRequestDTO;
@Data
@NoArgsConstructor
public class ReservationPageRequestDTO extends PageRequestDTO {
    Long id;

    public ReservationPageRequestDTO(int page, int size ) { super( page, size ); }

    public ReservationPageRequestDTO(int page, int size, Long id) {
        super( page, size );
        this.id = id;
    }

    public ReservationPageRequestDTO(Long id) {
        this.id = id;
    }
}
