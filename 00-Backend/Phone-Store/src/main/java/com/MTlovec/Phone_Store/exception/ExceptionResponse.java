package com.MTlovec.Phone_Store.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
    private  int status;
    private String message;
    private LocalDateTime timestamp;
}
