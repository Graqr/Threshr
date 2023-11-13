package com.github.graqr.combine;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@MicronautTest
public class CombineCmdTest extends CombineTest {

    String executeCommand(String[] args) {
        OutputStream out = new ByteArrayOutputStream();
        OutputStream errorOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(errorOut));
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(CombineCmd.class, ctx, args);
        }
        return out.toString();
    }

    @Test
    void smokeTest() {
        String[] command = new String[]{
                "-p", testApiKey,
                "-t", tcinList.getTcins()};
        assertDoesNotThrow(() -> executeCommand(command));
    }
}
