package com.natillera.demo.configuration.exceptionhandler;

import com.natillera.demo.domain.exception.NegativeNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(NegativeNotAllowedException.class)
    public ResponseEntity<ExceptionResponse> handleNegativeNotAllowedException(NegativeNotAllowedException exception)
    {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
}
