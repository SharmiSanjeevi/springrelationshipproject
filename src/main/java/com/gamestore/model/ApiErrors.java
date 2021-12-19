package com.gamestore.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ApiErrors {

    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String path;

    public ApiErrors(LocalDateTime timestamp, HttpStatus status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
