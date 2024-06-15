package com.graqr

import groovy.sql.Sql
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.context.annotation.Value
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
@Requires(property = "test.datasources.default.url")
class PdpCliSpec extends Specification {

    @Shared
    @Value('${test.datasources.default.url}')
    String url = null == url ? System.getenv("TEST_DATASOURCES_DEFAULT_URL") : url

    @Shared
    Sql sql

    @Shared
    final PrintStream originalOut = System.out
    @Shared
    final PrintStream originalErr = System.err

    @Shared
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
    ByteArrayOutputStream errStream = new ByteArrayOutputStream()


    @Shared
    @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)



    void setupSpec() {
        sql = Sql.newInstance(url)
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

    def "tcin arg exceeding 1 count fails"() {
        when:
        String[] tcinArg = sql.rows("select tcin FROM target_pdp TABLESAMPLE BERNOULLI (1) LIMIT 2")
                .collect(row -> row.tcin)
        PicocliRunner.run(Pdp, ctx, '--tcin', tcinArg.join(','), "--store-id", location_id as String)
        def matcher = errStream.toString() =~ ".*only one tcin can be provided.*"

        then: "has expected error message"
        matcher.size() == 1


        where:
        [location_id] << sql.rows('select location_id FROM target_stores TABLESAMPLE BERNOULLI (1) LIMIT 1')
    }

    //  ------------ Integration Tests ------------

    def "querying #tcin for #location_id returns expected data"() {
        when:"performing pdp query for #tcin and querying #location_id"
        PicocliRunner.run(Pdp, ctx, "--tcin", tcin as String, "--store-id", location_id as String)

        then:"error stream is empty"
        errStream.toString().isBlank()

        and: "output contains data for #tcin"
        outputStream.toString().startsWith("{\"__typename\":\"Product\",\"tcin\":\"${tcin}\"")

        where:
        [location_id] << sql.rows('select location_id FROM target_stores TABLESAMPLE BERNOULLI (1) LIMIT 5') //table has +2k records
        [tcin] << sql.rows("select tcin FROM target_pdp TABLESAMPLE BERNOULLI (1) LIMIT 5")
    }
}