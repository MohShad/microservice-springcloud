package com.springcloud.example.dto;

import lombok.Data;

@Data
public class ApiResponseDTO {

    private boolean success;
    private String message;

    public ApiResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}