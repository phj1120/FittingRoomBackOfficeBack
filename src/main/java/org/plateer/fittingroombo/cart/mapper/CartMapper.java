package org.plateer.fittingroombo.cart.mapper;

import org.plateer.fittingroombo.cart.dto.CartProductListDTO;
import org.plateer.fittingroombo.reservation.dto.GetReservationItemListDTO;

import java.util.List;

public interface CartMapper {


    List<CartProductListDTO> getReservationItemList(GetReservationItemListDTO getReservationItemListDTO);
}
