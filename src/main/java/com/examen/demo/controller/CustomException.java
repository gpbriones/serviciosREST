package com.examen.demo.controller;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
