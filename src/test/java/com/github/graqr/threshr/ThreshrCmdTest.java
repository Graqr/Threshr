package com.github.graqr.threshr;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

@MicronautTest
public class ThreshrCmdTest extends ThreshrTest {

    String executeCommand(String[] args) {
        OutputStream out = new ByteArrayOutputStream();
        OutputStream errorOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(errorOut));
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(ThreshrCmd.class, ctx, args);
        }
        return out.toString();
    }

//    @Test
//    void smokeTest() {
//        String[] command = new String[]{
//                "-p", System.getenv("REDSKY_TOKEN"),
//                "-t",  new TcinList(harvestedProducts[0].tcin()).getTcins()};
//        assertDoesNotThrow(() -> executeCommand(command));
//    }
}
