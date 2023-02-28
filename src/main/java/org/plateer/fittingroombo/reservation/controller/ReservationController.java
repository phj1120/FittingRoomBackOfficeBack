package org.plateer.fittingroombo.reservation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.cart.dto.CartProductListDTO;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.security.dto.CustomUserDetail;
import org.plateer.fittingroombo.reservation.dto.GetReservationItemListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationDTO;
import org.plateer.fittingroombo.reservation.dto.GetReservationListDTO;
import org.plateer.fittingroombo.reservation.dto.ReservationPageRequestDTO;
import org.plateer.fittingroombo.reservation.service.ReservationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;


    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("list")
    public PageResultDTO<GetReservationListDTO> getReservationList(@AuthenticationPrincipal CustomUserDetail user,
           ReservationPageRequestDTO reservationPageRequestDTO){

        reservationPageRequestDTO.setId(user.getUserNo());
        return reservationService.getReservationList(reservationPageRequestDTO);
    }

    @PreAuthorize("hasRole('SELLER')")
    @GetMapping("detail")
    public List<CartProductListDTO> getReservationDetail(@AuthenticationPrincipal CustomUserDetail user,
            GetReservationItemListDTO getReservationItemListDTO){
        getReservationItemListDTO.setSeNo(user.getUserNo());
        return reservationService.getReservationDetail(getReservationItemListDTO);
    }

    @PreAuthorize("hasRole('SELLER')")
    @PutMapping("detail/modify")
    public Long modifyReservationDetail(@AuthenticationPrincipal CustomUserDetail user,
                                        @RequestBody GetReservationItemListDTO getReservationItemListDTO){
        getReservationItemListDTO.setSeNo(user.getUserNo());
        return reservationService.modifyCartProductStatus(getReservationItemListDTO);
    }


}
