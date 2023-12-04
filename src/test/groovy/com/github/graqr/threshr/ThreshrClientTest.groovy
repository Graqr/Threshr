package com.github.graqr.threshr

import com.github.graqr.threshr.model.redsky.products.summary.Products
import io.micronaut.http.HttpResponse

//note: dont delete this test if you think this doubles the controller test. httpclient logs are visible in this test
class ThreshrClientTest extends ThreshrTest {

    void "no error calling product_summary_with_fulfillment_v1 endpoint"() {
        when:
        HttpResponse<Products> response = threshrClient.productSummaryWithFulfillment(
                targetStore,
                tcin
        )

        then:
        noExceptionThrown()
        response.body().data().productSummary().size() == tcin.getTcinCount()
    }
}
