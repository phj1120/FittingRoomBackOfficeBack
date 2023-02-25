package org.plateer.fittingroombo.store.controllerAdvice;

import org.plateer.fittingroombo.common.dto.ResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(RuntimeException.class)
    public ResultDTO runtimeException(RuntimeException runtimeException){

        return ResultDTO.<Long>builder().error(runtimeException.getMessage()).build();
    }
}
