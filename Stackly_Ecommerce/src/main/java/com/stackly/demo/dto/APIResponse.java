package com.stackly.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse<T> 
{
    private LocalDateTime timestamp;

    private int status;
    
    private String message;

    private T data;
}
