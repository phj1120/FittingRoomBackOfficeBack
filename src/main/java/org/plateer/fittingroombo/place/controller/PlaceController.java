package org.plateer.fittingroombo.place.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.dto.PlaceRoomDTO;
import org.plateer.fittingroombo.place.service.PlaceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/place")
public class PlaceController {
    private final PlaceService placeService;
    
    // 영업중인 장소 리스트
    @PreAuthorize("hasRole('PLACE')")
    @GetMapping("list")
    public List<PlaceRoomDTO> getPlaceRoomList() {
        return placeService.getPlaceRoomList();
    }

    // 특정 장소의 현황
    @GetMapping("{id}")
    public ResultDTO<PlaceRoomDTO> getPlaceRoom(@PathVariable("id") Long pmNo) {
        PlaceRoomDTO placeRoomDTO = placeService.getPlaceRoom(pmNo);
        return ResultDTO.<PlaceRoomDTO>builder().data(placeRoomDTO).build();
    }

    // 프로필 정보 업데이트
    @PostMapping("dress/profile")
    public ResultDTO<Long> updatePlaceInfo(@RequestBody PlaceDTO placeDTO) {
        Long pmNo = placeService.updatePlaceInfo(placeDTO);
        return ResultDTO.<Long>builder().data(pmNo).build();
    }

    // 장소제공자 회원가입
    @PostMapping
    public ResultDTO<Long> insertPlace(@RequestBody PlaceDTO placeDTO) {
        return ResultDTO.<Long>builder().data(1L).build();
    }
}
