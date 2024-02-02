package com.graqr.threshr

import com.graqr.threshr.model.queryparam.TargetStorePdpSearch
import com.graqr.threshr.model.redsky.products.pdp.client.PdpClientRoot
import com.graqr.threshr.model.redsky.products.summary.ProductSummaryRoot
import io.micronaut.http.HttpResponse

/**
 * This test class is necessary despite similarity to the controller test. please dont delete this as the
 * httpclient logs are visible in this test but not in the controller test.
 */
class ThreshrClientSpec extends ThreshrSpec {

    void "no error requesting product summaries"() {
        when:
        HttpResponse<ProductSummaryRoot> response = threshrClient.productSummaryWithFulfillment(
                targetStore, tcin)

        then:
        noExceptionThrown()
        response.body().data().productSummary().size() == tcin.tcins.split(",").size()
    }


    void "no error calling pdp client search"() {
        when:
        HttpResponse<PdpClientRoot> response = threshrClient.productDetails(
                new TargetStorePdpSearch(targetStore),
                tcin.getTcins().split(",")[0])

        then:
        noExceptionThrown()
        null != response.body().data().product()
    }
//
//    void "no error querying target store locations"() {
//        when:
//        HttpResponse<TargetStoreRoot> response = threshrClient.queryTargetStore()
//
//        then:
//    }
}
