package com.graqr.threshr

import com.graqr.threshr.Utils.nullCheck
import com.graqr.threshr.circleStore.client.ProductClient
import com.graqr.threshr.circleStore.client.StoreClient
import com.graqr.threshr.circleStore.model.product.details.PdpClientRoot
import com.graqr.threshr.circleStore.model.product.listings.PlpSearchRoot
import com.graqr.threshr.circleStore.model.product.summary.ProductSummaryRoot
import com.graqr.threshr.circleStore.model.queryparam.TargetStore
import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.annotation.Controller
import org.reactivestreams.Publisher

@Controller("/circleStore")
class CircleStore private constructor(
    private val productClient: ProductClient,
    private val storeClient: StoreClient,
    private val visitorID: String = Utils.getSecureRandomString(32)
) {

    /**
     * Query product summaries and their fulfillment options. see [ProductSummaryRoot]
     *
     * @param targetStore TargetStore object whose inventory is queried for product summaries
     * @param tcins       String object for one or many product ID(s)
     * @return List of product summaries, one for each ID in the tcin object.
     * @throws ThreshrException if no product summaries are returned by the query
     */
    @Throws(ThreshrException::class)
    fun getProductSummary(targetStore: TargetStore, vararg tcins: String): ProductSummaryRoot {
        return nullCheck(productClient.getProductSummary(targetStore, tcins.joinToString { "," }))
    }

    /**
     * Query product summaries and their fulfillment options. see [ProductSummaryRoot]
     *
     * @param targetStore TargetStore object whose inventory is queried for product summaries
     * @param tcins       String object for one or many product ID(s)
     * @return List of product summaries, one for each ID in the tcin object.
     * @throws ThreshrException if no product summaries are returned by the query
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun getProductSummaryAsync(targetStore: TargetStore, vararg tcins: String): Publisher<ProductSummaryRoot> {
        return productClient.getProductSummaryAsync(targetStore, tcins.joinToString { "," })
    }


    /**
     * Queries the product details page for a given product at a given store.
     *
     * @param pricingStoreId store identifier
     * @param storeId        store identifier
     * @param tcins          Target's internal product id number. aka 'Target Catalog Identification Number'
     * @return Product details matching the given query
     * @throws ThreshrException if no Product matching given query is found
     */
    @Throws(ThreshrException::class)
    fun getProductDetails(pricingStoreId: String, storeId: String, vararg tcins: String): PdpClientRoot {
        return nullCheck(productClient.getProductDetails(pricingStoreId, storeId, tcins.joinToString { "," }))
    }

    /**
     * Queries the product details page for a given product at a given store.
     *
     * @param pricingStoreId store identifier
     * @param storeId        store identifier
     * @param tcins          Target's internal product id number. aka 'Target Catalog Identification Number'
     * @return Product details matching the given query wrapped in a Publisher object.
     * @throws ThreshrException if no Product matching given query is found
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun getProductDetailsAsync(
        pricingStoreId: String, storeId: String, vararg tcins: String
    ): Publisher<PdpClientRoot> {
        return productClient.getProductDetailsAsync(pricingStoreId, storeId, tcins.joinToString { "," })
    }

    /**
     * Submits a product listings query with sensible default values for channel, page and visitorId. User provides offset value.
     * See[PlpSearchRoot].
     *
     * @param pricingStore store from which the product listings are to be queried.
     * @param category     Target's internal product category id.
     * @return Product Listing Search Root object
     */
    @Throws(ThreshrException::class)
    fun plpQuery(pricingStore: TargetStore, category: String, offset: Int): PlpSearchRoot {
        return nullCheck(
            productClient.getProductListings(
                pricingStore.storeId, visitorID, offset, category, "/c/$category"
            )
        )
    }

    /**
     * Submits a product listings query with sensible default values for channel, page and visitorId.
     * See[PlpSearchRoot].
     *
     * @param pricingStore store from which the product listings are to be queried.
     * @param category     Target's internal product category id.
     * @return Product Listing Search Root object wrapped in a Publisher Object
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun plpQueryAsync(pricingStore: TargetStore, category: String, offset: Int): Publisher<PlpSearchRoot> {
        return productClient.getProductListingsAsync(pricingStore.storeId, visitorID, offset, category, "/c/$category")
    }

}