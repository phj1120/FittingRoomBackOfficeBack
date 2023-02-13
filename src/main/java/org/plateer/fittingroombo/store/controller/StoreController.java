package org.plateer.fittingroombo.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.store.dto.ResultDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/seller/store")
public class StoreController {
    private final org.plateer.fittingroombo.store.service.StoreService StoreService;

    @GetMapping("/status/{id}")
    public ResultDTO getStoreList(@PathVariable("id") Long sNo){

        return StoreService.getStoreList(sNo);
    }
}
