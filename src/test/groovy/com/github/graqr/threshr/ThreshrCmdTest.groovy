package com.github.graqr.threshr

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared

@MicronautTest
class ThreshrCmdTest extends ThreshrTest {

    @Shared
    String[] helpText = new String[]{
            "Usage: threshr [-hV] [-p=<key>] [-t=<tcins>]",
            "pulls current pricing from target's api",
            "  -h, --help            Show this help message and exit.",
            "  -p, --key, --secret=<key>",
            "  -t, --tcins=<tcins>",
            "  -V, --version         Print version information and exit."}


    void "query help text"() {
        when:
        String[] args = new String[]{"-h"}
        String[] outputStreams = executeCommand(ThreshrCmd, args)

        then:
        for (String line : helpText)
            outputStreams[0].contains("Usage: threshr [-hV] [-p=<key>] [-t=<tcins>]")
    }

    def "varying tcin arg count with no error"() {
        when:
        String[] args = new String[]{"-t", tcinArgs}
        String[] streams = executeCommand(ThreshrCmd, args)

        then:
        streams[1].isEmpty()

        where:
        tcinArgs               | _
        tcin.getTcins()        | _
        tcin.getTcinByIndex(0) | _
    }

    def "invalid tcin args produce PicoCliError"() {
        when:
        String[] args = new String[]{"-t", tcinArgs}
        String[] streams = executeCommand(ThreshrCmd, args)

        then:
        for (String line : (helpText + new String[]{
                "Invalid value for option '--tcins': cannot convert ' ${tcinArgs}' to TcinList (picocli.CommandLine\$PicocliException: the following are invalid tcin: ${tcin})\n",
        })) {
            streams[1].contains(line)
        }
        where:
        tcinArgs            | _
        "8269153,129513464" | _ // too long and too short
        "8269153"           | _ // too short
        "123456789"         | _ // too long
        "eightVal"          | _ // proper length String of not numbers

    }

    /**
     * Emulates executing the given command class in the cli with the given args.
     *
     * @param commandClass picocli enabled class to be tested
     * @param args array of string args to be passed to command
     * @return standard and error out streams at index 0 and 1 respectively.
     */
    private String[] executeCommand(Class commandClass, String[] args) {
        OutputStream out = new ByteArrayOutputStream()
        OutputStream err = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        System.setErr(new PrintStream(err))
        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            PicocliRunner.run(commandClass, ctx, args)
        }
        new String[]{out.toString(), err.toString()}
    }
}