package com.github.peanutbutter.unicorn.tarvester.cmd;

import com.github.peanutbutter.unicorn.tarvester.TarvesterCmd;
import com.github.peanutbutter.unicorn.tarvester.TarvesterClient;
import com.github.peanutbutter.unicorn.tarvester.model.TargetStore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

public class TarvesterClientCmdTest {
    static CommandLine commandLine;
    TarvesterCmd tarvesterCmd;
    TarvesterClient tarvesterClient;
    long[] tcins;
    TargetStore targetStore = new TargetStore(
            "1750",
            "Centerville",
            "STORE",
            "200 N Market Place Dr",
            "Centerville",
            "UT",
            "84014-1752",
            "40.91825",
            "-111.887",
            "true",
            false,
            "8012920071",
            "false"
    );

    @BeforeEach
    void setUp() {
        tarvesterCmd = new TarvesterCmd();
        commandLine = new CommandLine(tarvesterCmd);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validateTcins() {
        tarvesterCmd.tcins = new long[]{82691535, 82642843, 85813668};
        Assertions.assertDoesNotThrow(() -> tarvesterCmd.validateTCIN());
    }

    @Test
    void testFetchProducts() {
        tarvesterCmd.tcins = new long[]{82691535, 82642843, 85813668};
        Assertions.assertDoesNotThrow(() -> tarvesterCmd.run());
    }
}