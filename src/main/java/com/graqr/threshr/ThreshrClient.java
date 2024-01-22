package com.graqr.threshr;

import com.graqr.threshr.model.TargetStore;
import com.graqr.threshr.model.TargetStorePdpSearch;
import com.graqr.threshr.model.Tcin;
import com.graqr.threshr.model.redsky.products.pdp.client.PdpClientRoot;
import com.graqr.threshr.model.redsky.products.summary.ProductSummaryRoot;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
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
public interface ThreshrClient {


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
            "&CHANNEL=${threshr.CHANNEL}")
    HttpResponse<ProductSummaryRoot> productSummaryWithFulfillment(
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
    HttpResponse<PdpClientRoot> productDetails(
            TargetStorePdpSearch targetStorePdpSearch,
            @Pattern(regexp = "(\\d{8})|(\\d{9})")
            String tcin);
}