package com.github.graqr.threshr;

import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.Tcin;
import com.github.graqr.threshr.model.redsky.ApiResponseData;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Client(id = "redsky-api")
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
public interface ThreshrClient {


    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     * Uses environment variables THRESHR_KEY and CHANNEL to authenticate.
     *
     * @param tcin          tcin ID's for products to query
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
     * Submits a search query to target's redsky api. Search results include pricing.
     *
     * @param key api key for the redsky api, normally provided by an environment variable.
     * @param tcin tcin ID's for products to query
     * @param targetStore store from which the product summaries are to be queried.
     * @return Search object in an ApiResponseData object, wrapped in an HttpResponse.
     */
    @Retryable
    @Get("/plp_search_v2{?key}{&member_id}{&targetStore.id}")
    HttpResponse<ApiResponseData> plpSearch(
            String key,
            Tcin tcin,
            TargetStore targetStore);
}
//https://redsky.target.com/redsky_aggregations/v1/web/
// plp_search_v2?key=9f36aeafbe60771e321a7cc95a78140772ab3e96
// &category=5q0f2
// &channel=WEB
// &member_id=1557340908
// &new_search=false
// &offset=0
// &page=/c/5q0f2
// &platform=desktop
// &pricing_store_id=1750
// &scheduled_delivery_store_id=1750
// &store_ids=1750%2C1755%2C2641%2C3365%2C2609
// &zip=84010