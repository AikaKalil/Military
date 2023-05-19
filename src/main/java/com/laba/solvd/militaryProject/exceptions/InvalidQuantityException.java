package com.laba.solvd.militaryProject.exceptions;

public class InvalidQuantityException extends Exception{
    public InvalidQuantityException() {
        super("Invalid quantity specified.");
    }
    public InvalidQuantityException(String message) {
        super(message);
    }
}
