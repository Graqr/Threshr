package com.github.graqr.threshr

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class ThreshrCmdTest extends ThreshrTest {


    void "query help text"() {
        when:
        String[] args = new String[]{"-h"}
        String[] outputStreams = executeCommand(ThreshrCmd, args)

        then:
        for (String line : new String[]{
                "Usage: threshr [-hV] [-p=<key>] [-t=<tcins>]",
                "pulls current pricing from target's api",
                "  -h, --help            Show this help message and exit.",
                "  -p, --key, --secret=<key>",
                "  -t, --tcins=<tcins>",
                "  -V, --version         Print version information and exit."})
            outputStreams[0].contains("Usage: threshr [-hV] [-p=<key>] [-t=<tcins>]")
    }

    def "provide varying tcin arg count with no error"() {
        when:
        String[] args = new String[]{"-t", tcinArgs}
        executeCommand(ThreshrCmd, args)

        then:
        noExceptionThrown()

        where:
        tcinArgs            | _
        "82691535,12953464" | _ //corn & coke https://bit.ly/45V8dui https://bit.ly/40j4A0e
        "82691535"          | _
    }

    /**
     * Emulates executing the given command class as a cli with the given args.
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
