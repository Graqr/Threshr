package com.graqr.threshr


import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class ThreshrControllerTest extends ThreshrTest {

    void "query product summaries with no error"() {
        when:
        threshrController.fetchProductSummaries(targetStore, tcin)

        then:
        noExceptionThrown()
    }
}