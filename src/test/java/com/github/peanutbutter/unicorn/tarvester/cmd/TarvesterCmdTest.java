package com.github.peanutbutter.unicorn.tarvester.cmd;

import com.github.peanutbutter.unicorn.tarvester.TarvesterCmd;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
        System.out.println(executeCommand("-t 82691535".split(" ")));
    }


    @Test
    void validateTcins() {
        TarvesterCmd tarvesterCmd = new TarvesterCmd();
        tarvesterCmd.tcins = new long[]{82691535, 82642843, 85813668};
        Assertions.assertDoesNotThrow(tarvesterCmd::validateTCIN);
    }
}
