package com.graqr.threshr

import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.redsky.product.pdp.client.PdpClientRoot
import com.graqr.threshr.model.redsky.product.plp.search.PlpSearchRoot
import com.graqr.threshr.model.redsky.product.summary.ProductSummaryRoot
import com.graqr.threshr.model.redsky.store.location.StoreLocationRoot
import com.graqr.threshr.model.redsky.store.nearby.NearbyStoreRoot
import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client


/**
 * Micronaut client for querying Target's Groceries api
 *
 * @author Jonathan Zollinger
 * @since 0.0.11
 */
@Client("redsky-api")
@Header(
    name = ACCEPT, value = "text/html," +
            "application/xhtml+xml," +
            "application/xml;q=0.9," +
            "image/avif,image/webp," +
            "image/png," +
            "image/svg+xml," +
            "*/*;q=0.8"
)
interface ThreshrClient {

    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     *
     * @param tcins       tcin ID's for products to query. see {@link Tcin#setTcins(String...)}
     * @param targetStore store from which the product summaries are to be queried.
     */
    @Get("/product_summary_with_fulfillment_v1")
    fun getProductSummary(
        @QueryValue("store_id") targetStore: TargetStore,
        @QueryValue("tcins") tcins: String, // comma separated list of tcins
        @QueryValue("channel") channel: String = "WEB"
    ): HttpResponse<ProductSummaryRoot>

    fun getProductSummary(targetStore: TargetStore, vararg tcins: String, channel: String): HttpResponse<ProductSummaryRoot> {
       return getProductSummary(targetStore, tcins.joinToString(","), channel)
    }

    /**
     * Get the pdp for the product with the given tcin from the given store.
     *
     * @param tcin           tcin ID's for products to query
     * @param pricingStoreId I really don't know why this second iteration of storeId is needed.
     * @param storeId        store from which the product summaries are to be queried.
     */
    @Get("/pdp_client_v1key=\${threshr.key}\${&tcin}\${&pricingStoreId}\${&storeId}")
    fun getProductDetails(
        @QueryValue("pricing_store_id") pricingStoreId: String,
        @QueryValue("store_id") storeId: String,
        tcin: String
    ): HttpResponse<PdpClientRoot>

    /**
     * Queries the 'plp_search_vs' endpoint for a given category at a given store. plp stands for product listing page.
     *
     * @param pricingStoreId store from which the product listings are to be queried.
     * @param visitorId      id for the visitor. This could be meaningless, but can't be null.
     * @param category       Target's internal category id.
     * @param page           Seems to be the category value prepended with "/c/"
     * @param channel        communication through which this api is being called. it's always 'WEB'
     * @return HttpResponse object containing ProductListings object
     */
    @Get(
        ("plp_search_v2?key=\${threshr.key}\${&category}\${&offset}\${&channel}\${&page}\${&pricingStoreId}\${&visitorId}")
    )
    fun getProductListings(
        @QueryValue("pricing_store_id") pricingStoreId: String, @QueryValue("visitor_id") visitorId: String,
        offset: Int, category: String, page: String, channel: String
    ): HttpResponse<PlpSearchRoot>

    /**
     * returns target stores within a given distance from a location.
     *
     * @param limit  count of locations to return
     * @param within distance from place to include in results
     * @param place  either a zipcode or a city + state wrapped as a place object
     * @return TargetStoreRoot object in an HttpResponse object. the NearbyStores object can be found in a
     * TargetStoreRoot object.
     */
    @Get("nearby_stores_v1key=\${threshr.key}\${&limit}\${&within}\${&place}&CHANNEL=\${threshr.channel}")
    fun getNearbyStores(limit: Int, within: Int, place: String): HttpResponse<NearbyStoreRoot>

    /**
     * Get Store Information (ie store hours) for a specific Target Store
     *
     * @return Store object, generally with more information about the store than other store endpoints.
     */
    @Get("store_location_v1key=\${threshr.key}\${&store}\${&channel}\${&page}")
    fun getStore(@QueryValue("store_id") store: String,channel: String,page: String): HttpResponse<StoreLocationRoot>
}