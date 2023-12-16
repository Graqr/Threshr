package com.github.graqr.threshr.utils;

import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class CliUtils {

    public static void isFileReadable(CommandSpec spec, String... paths) {
        isFileReadable(spec, Arrays.stream(paths).map(Paths::get).toArray(Path[]::new));
    }

    public static void isFileReadable(CommandSpec spec, Path... paths) {
        for (Path path : paths) {
            if (!Files.isReadable(path)) {
                String message = String.format("Invalid file '%s': file cannot be read.", path);
                //below isn't necessary, but gives more help. I think a good call to keep despite extra processing
                if (!Files.exists(path)) {
                    message = String.format("Invalid file '%s': file does not exist.", path);
                } else if (!Files.isRegularFile(path)) {
                    message = String.format("Invalid file '%s': file is not a regular file.", path);
                }
                throw new CommandLine.ParameterException(spec.commandLine(), message);
            }
        }
    }

    public static void isFileReadable(String... paths) {
        isFileReadable(Arrays.stream(paths).map(Paths::get).toArray(Path[]::new));
    }

    public static void isFileReadable(Path... paths) {
        for (Path path : paths) {
            if (!Files.isReadable(path)) {
                String message = String.format("Invalid file '%s': file cannot be read.", path);
                //below isn't necessary, but gives more help. I think a good call to keep despite extra processing
                if (!Files.exists(path)) {
                    message = String.format("Invalid file '%s': file does not exist.", path);
                } else if (!Files.isRegularFile(path)) {
                    message = String.format("Invalid file '%s': file is not a regular file.", path);
                }
                throw new ThreshrException(message);
            }
        }
    }
}
