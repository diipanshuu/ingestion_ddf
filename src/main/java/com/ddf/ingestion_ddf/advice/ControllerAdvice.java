package com.ddf.ingestion_ddf.advice;

import com.ddf.ingestion_ddf.request.mappers.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentTypeMismatch(){
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setMessage("Invalid order_by field. Please specify a valid value like: modifiedDate");

        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(400));
    }
}
