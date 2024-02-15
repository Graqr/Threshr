package com.graqr.threshr

import com.graqr.threshr.model.queryparam.Place
import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.queryparam.Tcin
import com.graqr.threshr.model.redsky.store.NearbyStore
import com.graqr.threshr.model.redsky.store.nearby.NearbyStoreRoot
import com.graqr.threshr.model.redsky.store.Store
import io.micronaut.context.annotation.Value
import io.micronaut.core.io.ResourceLoader
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import net.datafaker.Faker
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.Stream

@MicronautTest
class ThreshrSpec extends Specification {

    //  ----------- Resources / Fields -----------
    @Inject
    @Shared
    Threshr threshrController

    @Inject
    @Shared
    ThreshrClient threshrClient

    @Inject @Shared
    ResourceLoader resourceLoader

    @Inject
    ThreshrUtils threshrUtils;

    @Inject
    @Shared
    ObjectMapper mapper

    @Shared
    @Value('${threshr.test.data.stores}') // $env:THRESHR_TEST_DATA_STORES
    String storesFilePath

    @Shared
    List<Store> expectedStores

    void setupSpec() {
        expectedStores = threshrUtils
                .readFileToObject(String.format("classpath:%s", storesFilePath), NearbyStoreRoot)
                .data()
                .nearbyStores()
                .stores()
    }

    @Shared
    // TODO configure test data to be provided, not hardcoded
    TargetStore targetStore = new TargetStore(
            "1750",
            "UT",
            "84014-1752",
            40.91825,
            -111.887)

    @Shared
    Tcin tcin = new Tcin(
            new String[]{"82691535", "12953464"} //corn & coke https://bit.ly/45V8dui https://bit.ly/40j4A0e
    )

    //  ------------------ Tests ------------------

    void 'querying "#place.getPlace()" returns the "#expectedLocationName" store'() {
        when:
        NearbyStore response = threshrController.queryStoreLocations(place)

        then:
        response.stores()
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
}