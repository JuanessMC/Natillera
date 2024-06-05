package com.natillera.demo.configuration.exceptionhandler;

import com.natillera.demo.domain.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException(GeneralException exception)
    {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(), 400, LocalDateTime.now().toString()));
    }
}
