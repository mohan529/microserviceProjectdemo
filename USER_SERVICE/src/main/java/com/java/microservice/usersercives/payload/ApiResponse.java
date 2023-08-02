package com.java.microservice.usersercives.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private boolean success;
    private String msg;
    private HttpStatus status;
}
