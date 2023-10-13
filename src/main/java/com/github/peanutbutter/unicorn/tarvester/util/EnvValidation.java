package com.github.peanutbutter.unicorn.tarvester.util;

import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;

public class EnvValidation {

    public static void validateFile(CommandLine.Model.CommandSpec commandSpec, Path... paths) {
        for (Path path : paths) {
            if (!Files.isReadable(path)) {
                String message = String.format("Invalid file '%s':", path);
                if (!Files.exists(path)) {
                    message += " file does not exist.";
                } else if (!Files.isRegularFile(path)) {
                    message += " file is not a regular file.";
                } else {
                    message += " file cannot be read.";
                }
                throw new CommandLine.ParameterException(commandSpec.commandLine(), message);
            }
        }

    }
}
