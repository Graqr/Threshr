package com.github.peanutbutter.unicorn.tarvester.cmd;

import com.github.peanutbutter.unicorn.tarvester.TarvesterCmd;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmulatedCliTest {
    final PrintStream originalOut = System.out;
    final PrintStream originalErr = System.err;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ByteArrayOutputStream err = new ByteArrayOutputStream();
    static CommandLine commandLine;

    @BeforeEach
    void setUp() {
        out.reset();
        err.reset();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
        commandLine = new CommandLine(new TarvesterCmd());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testWithCommandLineOption() {
        long[] tcins = new long[]{82691535, 82642843, 85813668, 54556735, 78832377, 54556309, 54560630, 82628083,
                54558699, 54571053, 54567240, 87533518, 14917318, 85804763, 77788700, 54560287, 54535980, 54516414,
                82667184, 54530931, 54553288, 85825253, 54535968, 54556767};
        String[] commandArgs = new String[]{"-t", Arrays.stream(tcins)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","))};
                commandLine.execute(commandArgs);
        assertEquals("", err.toString());
    }
    }