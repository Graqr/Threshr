package com.graqr.threshr

import com.graqr.threshr.model.queryparam.Place
import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.queryparam.Tcin
import com.graqr.threshr.model.redsky.store.NearbyStore
import com.graqr.threshr.model.redsky.store.Store
import com.graqr.threshr.model.redsky.store.nearby.NearbyStoreRoot
import io.micronaut.context.annotation.Value
import io.micronaut.core.io.ResourceLoader
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Collectors

@MicronautTest
class ThreshrSpec extends Specification {

    //  ----------- Resources / Fields -----------
    @Inject
    @Shared
    Threshr threshrController

    @Inject
    @Shared
    ThreshrClient threshrClient

    @Inject
    @Shared
    ObjectMapper mapper

    @Inject
    @Shared
    ResourceLoader resourceLoader

    @Shared
    @Value('${threshr.test.data.stores}')
    String storesFilePath

    @Shared
    List<Store> expectedStores

    byte[] getResourceFromFile(String filepath) {
        try {
            return resourceLoader.getResourceAsStream(filepath).get().readAllBytes()
        } catch (IOException e) {
            throw new ThreshrException(String.format("failed to load '%s'.", filepath), e)
        }
    }


    void setupSpec() {
        expectedStores = mapper.readValue(getResourceFromFile("classpath:" + storesFilePath), NearbyStoreRoot.class)
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