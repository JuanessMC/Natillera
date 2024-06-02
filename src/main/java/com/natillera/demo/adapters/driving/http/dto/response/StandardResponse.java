package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class StandardResponse <T> {
    private final String message;
    private final String status;
    private final LocalDateTime timestamp;
    private List<T> records;
    private int count;
}
