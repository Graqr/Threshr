package com.github.graqr.threshr

import com.github.graqr.threshr.model.redsky.product.search.Data
import io.micronaut.http.HttpResponse

//note: this test enables logging the actual http requests being sent
class ThreshrClientTest extends ThreshrTest {

    void "no error calling product_summary_with_fulfillment_v1 endpoint"() {
        when:
        HttpResponse<Data> response = threshrClient.productSummaryWithFulfillment(
                targetStore,
                tcinList
        )

        then:
        noExceptionThrown()
        !response.body().productSummary().isEmpty()

    }
}
