package org.plateer.fittingroombo.reservation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.reservation.dto.GetReservationItemListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationDTO;
import org.plateer.fittingroombo.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationPageRequestDTO;

import java.util.List;

public interface ReservationMapper {

    void insertTest(ReservationDTO reservationDTO);

    List<GetReservationListDTO> getReservationList(ReservationPageRequestDTO reservationPageRequestDTO);

    int getReservationCount(ReservationPageRequestDTO reservationPageRequestDTO);
    Long modifyCartProductStatus(GetReservationItemListDTO reservationItemListDTO);

    Long modifyReservationStatus(GetReservationItemListDTO reservationItemListDTO);



}
