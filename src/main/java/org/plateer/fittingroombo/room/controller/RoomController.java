package org.plateer.fittingroombo.room.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.PageResultDTO;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryPageRequestDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.room.dto.RoomPageRequestDTO;
import org.plateer.fittingroombo.room.service.RoomService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("request")
    public ResultDTO<Long> insertRequestHistoryPlace(@RequestBody RequestHistoryDTO requestHistoryDTO) {
        Long rhNo = roomService.insertRequestHistoryPlace(requestHistoryDTO);
        return ResultDTO.<Long>builder().data(rhNo).build();
    }
}
