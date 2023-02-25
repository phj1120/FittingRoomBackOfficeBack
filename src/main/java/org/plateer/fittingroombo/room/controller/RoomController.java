package org.plateer.fittingroombo.room.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.common.security.dto.CustomUserDetail;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.room.dto.RoomPageRequestDTO;
import org.plateer.fittingroombo.room.service.RoomService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/room")
public class RoomController {
    private final RoomService roomService;

    @GetMapping("status/list")
    public PageResultDTO<RequestHistoryDTO> getRoomRequestHistoryList(RequestHistoryPageRequestDTO requestHistoryPageRequestDTO) {
        return roomService.getRoomRequestHistoryList(requestHistoryPageRequestDTO);
    }

    @PreAuthorize("hasRole('PLACE')")
    @PostMapping("request")
    public ResultDTO<Long> insertRequestHistoryPlace(@AuthenticationPrincipal CustomUserDetail user, @RequestBody RequestHistoryDTO requestHistoryDTO) {
        requestHistoryDTO.setPmNo(user.getUserNo());
        Long rhNo = roomService.insertRequestHistoryPlace(requestHistoryDTO);
        return ResultDTO.<Long>builder().data(rhNo).build();
    }

    @PreAuthorize("hasRole('PLACE')")
    @GetMapping("request/list")
    public List<RequestHistoryDTO> getRequestHistoryPlace(@AuthenticationPrincipal CustomUserDetail user) {
        return roomService.getRequestHistoryPlace(user.getUserNo());
    }

    @PreAuthorize("hasRole('PLACE')")
    @PutMapping("request/list")
    public ResultDTO<Long> updateRequestHistoryPlace(@AuthenticationPrincipal CustomUserDetail user, @RequestBody RequestHistoryDTO requestHistoryDTO) {
        requestHistoryDTO.setPmNo(user.getUserNo());
        Long rhNo = roomService.updateRequestHistoryPlace(requestHistoryDTO);
        return ResultDTO.<Long>builder().data(rhNo).build();
    }
}
