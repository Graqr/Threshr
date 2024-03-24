package com.graqr.threshr

import com.graqr.threshr.model.queryparam.Place
import com.graqr.threshr.model.redsky.product.pdp.client.PdpClientRoot
import com.graqr.threshr.model.redsky.product.summary.ProductSummaryRoot
import com.graqr.threshr.model.redsky.store.location.StoreLocationRoot
import com.graqr.threshr.model.redsky.store.nearby.NearbyStoreRoot
import io.micronaut.http.HttpResponse

import java.util.stream.Collectors
/**
 * This test class is necessary despite similarity to the controller test. please don't delete this as the
 * httpclient logs are visible in this test but not in the controller test.
 */
class ThreshrClientSpec extends ThreshrSpec {


    void "no error requesting product summaries"() {
        when:
        HttpResponse<ProductSummaryRoot> response = threshrClient.getProductSummary(
                targetStore, tcin)

        then:
        noExceptionThrown()
        response.body().data().productSummary().size() == tcin.tcins.split(",").size()
    }

    void "no error calling pdp client search"() {
        when:
        HttpResponse<PdpClientRoot> response = threshrClient.getProductDetails(
                targetStore.getStoreId(),
                targetStore.getStoreId(),
                tcin.getTcins().split(",")[0])

        then:
        noExceptionThrown()
        null != response.body().data().product()
    }

    void 'querying "#place.getZipOrCityState()" returns the "#expectedLocationName" store'() {
        when:
        HttpResponse<NearbyStoreRoot> response = threshrClient.getNearbyStores(5,100, place.getZipOrCityState())

        then:
        response.body().data().nearbyStores().stores()
                .stream()
                .map(it -> it.locationName())
                .collect(Collectors.toList())
                .contains(expectedLocationName)

        where:
        store << expectedStores
        expectedLocationName = store.locationName()
        place = 0 == new Random().nextInt(2)
                ? new Place(store.mailingAddress().postalCode())
                : new Place(store.mailingAddress().city(), store.mailingAddress().state())
    }

    void "test querying store #expectedStore.storeId() throws no error"() { // see related test in controller spec
        when:
        HttpResponse<StoreLocationRoot> response = threshrClient.getStore(expectedStore.storeId(), "web", "/c/root")

        then:
        noExceptionThrown()
        null != response.body()

        where:
        expectedStore << expectedStores
    }
}
