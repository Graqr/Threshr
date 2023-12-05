package com.github.graqr.threshr

import com.github.graqr.threshr.model.TargetStorePdpSearch
import com.github.graqr.threshr.model.redsky.products.pdp.client.ClientResponse
import com.github.graqr.threshr.model.redsky.products.summary.ProductSummaryWithFulfillment
import io.micronaut.http.HttpResponse
/**
 * This test class is necessary despite similarity to the controller test. please dont delete this as the
 * httpclient logs are visible in this test but not in the controller test.
 */
class ThreshrClientTest extends ThreshrTest {

    void "no error requesting product summaries"() {
        when:
        HttpResponse<ProductSummaryWithFulfillment> response = threshrClient.productSummaryWithFulfillment(
                targetStore, tcin)

        then:
        noExceptionThrown()
        response.body().data().productSummary().size() == tcin.tcins.split(",").size()
    }


    void "no error calling pdp client search"() {
        when:
        HttpResponse<ClientResponse> response = threshrClient.pdpClient(
                new TargetStorePdpSearch(targetStore),
                tcin.getTcins().split(",")[0])

        then:
        noExceptionThrown()
        null != response.body().data().product()
    }
}
