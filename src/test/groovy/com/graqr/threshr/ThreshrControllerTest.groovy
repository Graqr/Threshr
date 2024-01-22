package com.graqr.threshr


import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class ThreshrControllerTest extends ThreshrTest {

    void "query product summaries with no error"() {
        when:
        threshrController.fetchProductSummariesWithFulfillment(targetStore, tcin)

        then:
        noExceptionThrown()
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