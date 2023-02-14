package org.plateer.fittingroombo.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.requestHistory.dto.RequestHistoryDTO;
import org.plateer.fittingroombo.store.dto.ResultDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/seller/store")
public class StoreController {
    private final org.plateer.fittingroombo.store.service.StoreService StoreService;

    @GetMapping("/status/{id}")
    public ResultDTO getStoreList(@PathVariable("id") Long seNo) {

        return StoreService.getStoreList(seNo);
    }

    @PutMapping("/status/{id}")
    public Long updateRequestHistorySeller(@PathVariable("id") Long rhNo,
                                     @RequestBody RequestHistoryDTO requestHistoryDTO) {
        RequestHistoryDTO updateHistoryObj = requestHistoryDTO;
        updateHistoryObj.setRhNo(rhNo);
        return StoreService.updateRequestHistorySeller(updateHistoryObj);
    }

    @GetMapping("/status/detail/{id}")
    public RequestHistoryDTO getRequestHistoryDetail(@PathVariable("id") Long rhNo){

        return StoreService.getRequestHistoryDetailSeller(rhNo);
    }

    @PostMapping("/request")
    public Long insertRequestHistorySeller(@RequestBody RequestHistoryDTO requestHistoryDTO) {
        return StoreService.insertRequestHistorySeller(requestHistoryDTO);
    }


}
