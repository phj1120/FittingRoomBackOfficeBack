package org.plateer.fittingroombo.order.mapper;

import org.plateer.fittingroombo.reservation.dto.GetReservationItemListDTO;

public interface OrderMapper {

    Long insertModifyReservation(GetReservationItemListDTO getReservationItemListDTO);
}
