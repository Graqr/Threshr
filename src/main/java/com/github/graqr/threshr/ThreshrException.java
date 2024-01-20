package com.github.graqr.threshr;

public class ThreshrException extends Exception{
    public ThreshrException(String message, Throwable err) {
        super(message, err);
    }

    public ThreshrException(String message) {
        super(message);
    }
}
