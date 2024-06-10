package com.graqr

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ThreshrCliSpec extends Specification {


    @Shared
    final PrintStream originalOut = System.out
    @Shared
    final PrintStream originalErr = System.err

    @Shared
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
    ByteArrayOutputStream errStream = new ByteArrayOutputStream()

    void execute(String... args) {
        try(ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST) as ApplicationContext) {
            PicocliRunner.run(ThreshrCli, ctx, args)
        }
    }


    def setup() {
        outputStream.reset()
        errStream.reset()
        System.setOut(new PrintStream(outputStream))
        System.setErr(new PrintStream(errStream))
    }

    def cleanup() {
        System.setOut(originalOut)
        System.setErr(originalErr)
    }

    def "cli help can be queried successfully"(){
        when:
        execute('--help')
        then:
        errStream.toString().trim().contains('Usage:')
    }

}
