package com.github.graqr.threshr

class ThreshrClientTest extends ThreshrTest {

    void "no error calling product_summary_with_fulfillment_v1 endpoint"() {
        when:
        threshrClient.productSummaryWithFulfillment(
                metadata,
                redskyToken,
                tcinList,
                targetStore
        )

        then:
        noExceptionThrown()
    }
}
