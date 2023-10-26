package com.github.peanutbutter.unicorn.tarvester.cmd;

import com.github.peanutbutter.unicorn.tarvester.TarvesterCmd;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TarvesterCmdTest {

    String executeCommand(String[] args){
        OutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(TarvesterCmd.class, ctx, args);
        }
        return baos.toString();
    }

    @Test
    void smokeTest() {
        assertDoesNotThrow(() -> executeCommand("-t 82691535".split(" ")));
    }
}
