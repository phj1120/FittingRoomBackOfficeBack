package org.plateer.fittingroombo.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class OrderServiceImpl implements OrderService{

    private final OrderMapper orderMapper;
    @Override
    public Long insertModifyReservation(Long reNo) {
        return orderMapper.insertModifyReservation(reNo);
    }
}
