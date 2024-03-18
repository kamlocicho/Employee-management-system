package com.example.employermanagementsystem.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends Exception {
    private final String title;
    private final int status;

    public CustomException(String title, String message, int status) {
        super(message);
        this.title = title;
        this.status = status;
    }
}
