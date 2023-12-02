package com.github.graqr.threshr;

import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.Tcin;
import com.github.graqr.threshr.model.redsky.ApiResponseData;
import com.github.graqr.threshr.model.redsky.Search;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

/**
 * This is a Micronaut HttpClient which consumes the target corporation's api.
 * <p>
 * Uses the following environment variables:
 * <ul>
 *     <li>THRESHR_KEY: bearer token to authenticate against the redsky api.</li>
 *     <li>THRESHR_CATEGORY:</li>TODO figure what this actually does
 *     <li>THRESHR_CHANNEL:</li>TODO figure what this actually does
 *     <li><dfn id="THRESHR_NEW_SEARCH:">THRESHR_NEW_SEARCH</dfn>: boolean value. probably {@code false}</li>
 *     <li>THRESHR_OFFSET:</li>TODO figure what this actually does
 *     <li>THRESHR_PAGE:</li>TODO figure what this actually does
 *     <li><dfn id="THRESHR_PLATFORM">THRESHR_PLATFORM</dfn>: Where the api calls are made. probably {@code desktop}
 *     </li>
 * </ul>
 * </p>
 */
@Client(id = "redsky-api")
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
public interface ThreshrClient {


    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     * Uses environment variables THRESHR_KEY and THRESHR_CHANNEL to authenticate.
     *
     * @param tcins       tcin ID's for products to query. see {@link Tcin#setTcins(String...)}
     * @param targetStore store from which the product summaries are to be queried.
     * @return List {@literal <}ProductSummary{@literal >} in an ApiResponseData object, wrapped in an HttpResponse.
     */
    @Retryable
    @Get("/product_summary_with_fulfillment_v1" +
            "?key=${threshr.key}" +
            "{&tcins*}" +
            "{&targetStore*}" +
            "&CHANNEL=${threshr.CHANNEL}")
    HttpResponse<ApiResponseData> productSummaryWithFulfillment(
            TargetStore targetStore,
            Tcin tcins);

    /**
     * Submits a search query to target's redsky api. {@link com.github.graqr.threshr.model.redsky.Search} results
     * include pricing.
     * <p>
     * Uses the following environment variables (See {@link ThreshrClient}).
     * <ul>
     *     <li>THRESHR_KEY</li>
     *     <li>THRESHR_CATEGORY</li>
     *     <li>THRESHR_CHANNEL</li>
     *     <li>THRESHR_NEW_SEARCH</li>
     *     <li>THRESHR_OFFSET</li>
     *     <li>THRESHR_PAGE</li>
     *     <li>THRESHR_PLATFORM</li>
     * </ul>
     *
     * @param tcin tcin ID's for products to query
     * @param targetStore store from which the product summaries are to be queried.
     * @return {@link Search} object in an {@link ApiResponseData} wrapped in an HttpResponse.
     */
    @Retryable
    @Get("/plp_search_v2" +
            "?key=${threshr.key}" +
            "&category=${threshr.category}" +
            "&member_id=${threshr.visitor}" +
            "{&targetStore.id}")
    HttpResponse<ApiResponseData> plpSearch(
            Tcin tcin,
            TargetStore targetStore);
}
