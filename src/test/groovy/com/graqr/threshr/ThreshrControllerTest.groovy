package com.graqr.threshr

import com.graqr.threshr.model.Tcin
import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class ThreshrControllerTest extends ThreshrTest {

    void "query product summaries with no error with tcin string(s)"() {
        when:
        threshrController.fetchProductSummariesWithFulfillment(targetStore, tcinArg)

        then:
        noExceptionThrown()

        where:
        tcinArg                         | _
        tcin.getTcins().split(",")[0]   | _
        tcin.getTcins().split(",")      | _
    }

    void "query product summaries with no error tcin type arg"() {
        when:
        threshrController.fetchProductSummariesWithFulfillment(targetStore, tcinArg)

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