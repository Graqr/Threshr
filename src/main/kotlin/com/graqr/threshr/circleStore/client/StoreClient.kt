package com.graqr.threshr.circleStore.client

import com.graqr.threshr.circleStore.model.store.location.StoreLocationRoot
import com.graqr.threshr.circleStore.model.store.nearby.NearbyStoreRoot
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import org.reactivestreams.Publisher

@Client("circle-api")
internal interface StoreClient {

    /**
     * returns target stores within a given distance from a location.
     *
     * @param limit  count of locations to return
     * @param within distance from place to include in results
     * @param place  either a zipcode or a city + state wrapped as a place object
     * @return TargetStoreRoot object in an HttpResponse object. the NearbyStores object can be found in a
     * TargetStoreRoot object.
     */
    @Get("nearby_stores_v1")
    fun getNearbyStores(
        @QueryValue limit: Int,
        @QueryValue within: Int,
        @QueryValue place: String,
        @QueryValue("CHANNEL") channel: String = "WEB"
    ): HttpResponse<NearbyStoreRoot>

    /**
     * returns target stores within a given distance from a location.
     *
     * @param limit  count of locations to return
     * @param within distance from place to include in results
     * @param place  either a zipcode or a city + state wrapped as a place object
     * @return TargetStoreRoot object in an HttpResponse object. the NearbyStores object can be found in a
     * TargetStoreRoot object.
     */
    @Get("nearby_stores_v1")
    fun getNearbyStoresAsync(
        @QueryValue limit: Int,
        @QueryValue within: Int,
        @QueryValue place: String,
        @QueryValue("CHANNEL") channel: String = "WEB"
    ): Publisher<NearbyStoreRoot>

    /**
     * Get Store Information (ie store hours) for a specific Target Store
     *
     * @return Store object, generally with more information about the store than other store endpoints.
     */
    @Get("store_location_v1")
    fun getStore(
        @QueryValue("store_id") store: String, @QueryValue("CHANNEL") channel: String = "WEB", @QueryValue page: String
    ): HttpResponse<StoreLocationRoot>

    /**
     * Get Store Information (ie store hours) for a specific Target Store
     *
     * @return Store object, generally with more information about the store than other store endpoints.
     */
    @Get("store_location_v1")
    fun getStoreAsync(
        @QueryValue("store_id") store: String, @QueryValue("CHANNEL") channel: String = "WEB", @QueryValue page: String
    ): Publisher<StoreLocationRoot>
}