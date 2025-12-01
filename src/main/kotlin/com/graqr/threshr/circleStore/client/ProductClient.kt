package com.graqr.threshr.circleStore.client

import com.graqr.threshr.circleStore.model.product.details.PdpClientRoot
import com.graqr.threshr.circleStore.model.product.listings.PlpSearchRoot
import com.graqr.threshr.circleStore.model.product.summary.ProductSummaryRoot
import com.graqr.threshr.circleStore.model.queryparam.TargetStore
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import org.reactivestreams.Publisher

@Client("circle-api")
internal interface ProductClient {

    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     *
     * @param tcins       tcin ID's for products to query as a comma separated values.
     * @param targetStore store from which the product summaries are to be queried.
     */
    @Get("/product_summary_with_fulfillment_v1")
    fun getProductSummary(
        @QueryValue("store_id") targetStore: TargetStore,
        @QueryValue tcins: String,
        @QueryValue("CHANNEL") channel: String = "WEB"
    ): HttpResponse<ProductSummaryRoot>

    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     *
     * @param tcins       tcin ID's for products to query as a comma separated values.
     * @param targetStore store from which the product summaries are to be queried.
     */
    @Get("/product_summary_with_fulfillment_v1")
    fun getProductSummaryAsync(
        @QueryValue("store_id") targetStore: TargetStore,
        @QueryValue tcins: String,
        @QueryValue("CHANNEL") channel: String = "WEB"
    ): Publisher<ProductSummaryRoot>

    /**
     * Get the details page for a given product the given tcin from the given store.
     *
     * @param tcin           tcin ID for products to query
     * @param pricingStoreId I really don't know why this second iteration of storeId is needed.
     * @param storeId        store from which the product summaries are to be queried.
     */
    @Get("/pdp_client_v1")
    fun getProductDetails(
        @QueryValue("pricing_store_id") pricingStoreId: String,
        @QueryValue("store_id") storeId: String,
        @QueryValue tcin: String
    ): HttpResponse<PdpClientRoot>

    /**
     * Get the details page for a given product the given tcin from the given store.
     *
     * @param tcin           tcin ID for products to query
     * @param pricingStoreId I really don't know why this second iteration of storeId is needed.
     * @param storeId        store from which the product summaries are to be queried.
     */
    @Get("/pdp_client_v1")
    fun getProductDetailsAsync(
        @QueryValue("pricing_store_id") pricingStoreId: String,
        @QueryValue("store_id") storeId: String,
        @QueryValue tcin: String
    ): Publisher<PdpClientRoot>

    /**
     * Queries the product listing endpoint for a given category at a given store. plp stands for product listing page.
     *
     * @param pricingStoreId store from which the product listings are to be queried.
     * @param visitorId      id for the visitor. This could be meaningless, but can't be null.
     * @param category       Target's internal category id.
     * @param page           Seems to be the category value prepended with "/c/"
     * @param channel        communication through which this api is being called. it's always 'WEB'
     * @return HttpResponse object containing ProductListings object
     */
    @Get("plp_search_v2")
    fun getProductListings(
        @QueryValue("pricing_store_id") pricingStoreId: String,
        @QueryValue("visitor_id") visitorId: String,
        @QueryValue offset: Int = 0,
        @QueryValue category: String,
        @QueryValue page: String,
        @QueryValue("CHANNEL") channel: String = "WEB"
    ): HttpResponse<PlpSearchRoot>

    /**
     * Queries the product listing endpoint for a given category at a given store. plp stands for product listing page.
     *
     * @param pricingStoreId store from which the product listings are to be queried.
     * @param visitorId      id for the visitor. This could be meaningless, but can't be null.
     * @param category       Target's internal category id.
     * @param page           Seems to be the category value prepended with "/c/"
     * @param channel        communication through which this api is being called. it's always 'WEB'
     * @return HttpResponse object containing ProductListings object
     */
    @Get("plp_search_v2")
    fun getProductListingsAsync(
        @QueryValue("pricing_store_id") pricingStoreId: String,
        @QueryValue("visitor_id") visitorId: String,
        @QueryValue offset: Int = 0,
        @QueryValue category: String,
        @QueryValue page: String,
        @QueryValue("CHANNEL") channel: String = "WEB"
    ): Publisher<PlpSearchRoot>
}