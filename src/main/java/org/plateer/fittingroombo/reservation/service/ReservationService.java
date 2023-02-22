package org.plateer.fittingroombo.reservation.service;

import org.plateer.fittingroombo.cart.dto.CartProductListDTO;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.reservation.dto.GetReservationItemListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationDTO;
import org.plateer.fittingroombo.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationPageRequestDTO;

import java.util.List;

public interface ReservationService {


    PageResultDTO<GetReservationListDTO> getReservationList(ReservationPageRequestDTO reservationPageRequestDTO);

    List<CartProductListDTO> getReservationDetail(GetReservationItemListDTO getReservationItemListDTO);

    Long modifyCartProductStatus(GetReservationItemListDTO getReservationItemListDTO);


}
