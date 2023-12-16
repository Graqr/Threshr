package com.github.graqr.threshr.utils;

import picocli.CommandLine;

public class ThreshrException extends CommandLine.PicocliException {
    public ThreshrException(String msg) {
        super(msg);
    }

    public ThreshrException(String msg, Throwable t) {
        super(msg, t);
    }
}
