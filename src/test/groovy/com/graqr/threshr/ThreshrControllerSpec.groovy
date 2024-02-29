package com.graqr.threshr

import com.graqr.threshr.model.queryparam.Tcin
import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class ThreshrControllerSpec extends ThreshrSpec {

    @Shared
    @Value('${test.datasources.default.dialect}')
    String dialect
    @Shared
    @Value('${test.datasources.default.driver}')
    String driver
    @Shared
    @Value('${test.datasources.default.url}')
    String url
    @Shared
    @Value('${test.datasources.default.username}')
    String username
    @Shared
    @Value('${test.datasources.default.password}')
    String password

    @Shared
    Sql sql

    void setupSpec() {
        sql = Sql.newInstance(url, username, password, driver)
    }
//    void cleanupSpec() {
//        sql.close()
//    }

    // https://github.com/Graqr/Threshr/issues/67
    void "query product summaries with no error with tcin string(s)"() {
        when:
        threshrController.fetchProductSummaries(targetStore, tcinArg as String)

        then:
        noExceptionThrown()

        where:
        tcinArg << new String[]{
                tcin.getTcins().split(",")[0],
                tcin.getTcins().split(",")
        }
    }

    void "query product summaries with no error tcin type arg"() {
        when:
        threshrController.fetchProductSummaries(targetStore, tcinArg)

        then:
        noExceptionThrown()

        where:
        tcinArg                                 | _
        tcin                                    | _
        new Tcin(tcin.getTcins().split(",")[0]) | _
    }

    void "query product details with no error"() {
        when:
        threshrController.fetchProductDetails(targetStore,
                tcin.getTcins().split(",")[0]
        )

        then:
        noExceptionThrown()
    }
}