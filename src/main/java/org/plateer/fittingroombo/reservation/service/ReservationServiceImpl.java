package org.plateer.fittingroombo.reservation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.cart.dto.CartProductListDTO;
import org.plateer.fittingroombo.cart.mapper.CartMapper;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.order.mapper.OrderMapper;
import org.plateer.fittingroombo.reservation.dto.GetReservationItemListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationDTO;
import org.plateer.fittingroombo.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationPageRequestDTO;
import org.plateer.fittingroombo.reservation.mapper.ReservationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ReservationServiceImpl implements ReservationService{
    private final ReservationMapper reservationMapper;
    private final CartMapper cartMapper;

    private final OrderMapper orderMapper;
    @Override
    public PageResultDTO<GetReservationListDTO> getReservationList(ReservationPageRequestDTO reservationPageRequestDTO) {

        int total = reservationMapper.getReservationCount(reservationPageRequestDTO);

        List<GetReservationListDTO> dtoList = reservationMapper.getReservationList(reservationPageRequestDTO);

        PageResultDTO<GetReservationListDTO> pageResultDTO = PageResultDTO.<GetReservationListDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(reservationPageRequestDTO)
                .build();

        return pageResultDTO;
    }

    @Override
    public List<CartProductListDTO> getReservationDetail(GetReservationItemListDTO getReservationItemListDTO) {
        return cartMapper.getReservationItemList(getReservationItemListDTO);
    }

    @Override
    public Long modifyCartProductStatus(GetReservationItemListDTO getReservationItemListDTO) {
        orderMapper.insertModifyReservation(getReservationItemListDTO);
        reservationMapper.modifyCartProductStatus(getReservationItemListDTO);
        return  reservationMapper.modifyReservationStatus(getReservationItemListDTO);
    }
}
