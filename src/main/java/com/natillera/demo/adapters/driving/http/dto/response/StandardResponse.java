package com.natillera.demo.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class StandardResponse <T> {
    private final String message;
    private final int status;
    private final String timestamp;
    private T data;
}
