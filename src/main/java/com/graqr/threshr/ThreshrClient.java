package com.graqr.threshr;

import com.graqr.threshr.model.queryparam.TargetStore;
import com.graqr.threshr.model.queryparam.TargetStorePdpSearch;
import com.graqr.threshr.model.queryparam.Tcin;
import com.graqr.threshr.model.redsky.product.pdp.client.PdpClientRoot;
import com.graqr.threshr.model.redsky.product.summary.ProductSummaryRoot;
import com.graqr.threshr.model.redsky.store.location.StoreLocationRoot;
import com.graqr.threshr.model.redsky.store.nearby.NearbyStoreRoot;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import jakarta.validation.constraints.Pattern;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

/**
 * This is a Micronaut HttpClient which consumes the target corporation's api.
 * <p>
 * Uses the following environment variables:
 * <ul>
 *     <li><dfn id="KEY">THRESHR_KEY</dfn>: bearer token to authenticate against the redsky api.</li>
 *     <li><dfn id="VISITOR">THRESHR_VISITOR</dfn>: query value for member_id variable</li>
 *     <li><dfn id="CATEGORY">THRESHR_CATEGORY</dfn>: grocery category id.</li>
 *     <li><dfn id="CHANNEL">THRESHR_CHANNEL</dfn>: medium through which this api is exchanged. probably {@code WEB}</li>
 *     <li><dfn id="SEARCH:">THRESHR_NEW_SEARCH</dfn>: boolean value. probably {@code false}</li>
 *     <li><dfn id="OFFSET">THRESHR_OFFSET</dfn>: not entirely sure, but I think this is a starting position. seems to always be {@code 0}</li>
 *     <li><dfn id="PAGE">THRESHR_PAGE</dfn>: seems to always be a single character id related to category somehow.</li>
 *     <li><dfn id="PLATFORM">THRESHR_PLATFORM</dfn>: Where the api calls are made. probably {@code desktop}
 *     </li>
 * </ul>
 * </p>
 */
@Client(id = "redsky-api")
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
interface ThreshrClient {

    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     * Uses environment variables THRESHR_KEY and THRESHR_CHANNEL to authenticate.
     *
     * @param tcins       tcin ID's for products to query. see {@link Tcin#setTcins(String...)}
     * @param targetStore store from which the product summaries are to be queried.
     */
    @Retryable
    @Get("/product_summary_with_fulfillment_v1" +
            "?key=${threshr.key}" +
            "{&tcins*}" +
            "{&targetStore*}" +
            "&CHANNEL=${threshr.channel}")
    HttpResponse<ProductSummaryRoot> getProductSummary(
            TargetStore targetStore,
            Tcin tcins);

    /**
     * @param tcin                 tcin ID's for products to query
     * @param targetStorePdpSearch store from which the product summaries are to be queried.
     */
    @Retryable
    @Get("/pdp_client_v1" +
            "?key=${threshr.key}" +
            "{&tcin}" +
            "{&targetStorePdpSearch*}")
    HttpResponse<PdpClientRoot> getProductDetails(
            TargetStorePdpSearch targetStorePdpSearch,
            @Pattern(regexp = "(\\d{8})|(\\d{9})")
            String tcin);

    /**
     * returns target stores within a given distance from a location.
     *
     * @param limit  count of locations to return
     * @param within distance from place to include in results
     * @param place  either a zipcode or a city + state wrapped as a place object
     * @return TargetStoreRoot object in an HttpResponse object. the NearbyStores object can be found in a
     * TargetStoreRoot object.
     */
    @Retryable
    @Get("nearby_stores_v1" +
            "?key=${threshr.key}" +
            "{&limit}" +
            "{&within}" +
            "{&place}" +
            "&CHANNEL=${threshr.channel}")
    HttpResponse<NearbyStoreRoot> getNearbyStores(int limit, int within, String place);

    /**
     * Get Store Information (ie store hours) for a specific Target Store
     * @return Store object, generally with more information about the store than other store endpoints.
     */
    @Get("store_location_v1" +
            "?key=${threshr.key}" +
            "{&store}" +
            "{&channel}" +
            "{&page}")
    HttpResponse<StoreLocationRoot> getStore(@QueryValue("store_id") String store, String channel, String page);

}