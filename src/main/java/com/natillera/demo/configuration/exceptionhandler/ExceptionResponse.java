package com.natillera.demo.configuration.exceptionhandler;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private final String message;
    private final int status;
    private final LocalDateTime timestamp;

    public ExceptionResponse(String message, int status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
