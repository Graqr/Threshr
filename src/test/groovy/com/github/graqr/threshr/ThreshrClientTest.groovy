package com.github.graqr.threshr

//note: this test enables logging the actual http requests being sent
class ThreshrClientTest extends ThreshrTest {

    void "no error calling product_summary_with_fulfillment_v1 endpoint"() {
        when:
        threshrClient.productSummaryWithFulfillment(
                targetStore,
                "WEB",
                tcinList
        )

        then:
        noExceptionThrown()
    }
}
