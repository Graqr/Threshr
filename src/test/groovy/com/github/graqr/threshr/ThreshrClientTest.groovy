package com.github.graqr.threshr


import io.micronaut.http.HttpResponse

//note: this test enables logging the actual http requests being sent
class ThreshrClientTest extends ThreshrTest {

    void "no error calling product_summary_with_fulfillment_v1 endpoint"() {
        when:
        HttpResponse<?> response = threshrClient.productSummaryWithFulfillment(
                targetStore,
                tcinList
        )

        then:
        noExceptionThrown()
        !response.body()

    }
}
