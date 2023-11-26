package com.github.graqr.threshr;

import com.github.graqr.threshr.model.RedskyQueryMetadata;
import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.TcinList;
import com.github.graqr.threshr.model.redsky.ApiResponseData;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Client(id = "redsky-api")
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
public interface ThreshrClient {

    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     *
     * @param metadata    values like channel, category, page and  customerId.
     * @param key         api key for the redsky api, normally provided by an environment variable.
     * @param tcinList    tcin ID's for products to query
     * @param targetStore store from which the product summaries are to be queried.
     * @return List\<ProductSummary\> in an ApiResponseData object, wrapped in an HttpResponse.
     */
    @Get("/product_summary_with_fulfillment_v1" +
            "{?key}" +
            "{&metadata.channel}" +
            "{&tcinList*}" +
            "{&targetStore*}")
    HttpResponse<ApiResponseData> productSummaryWithFulfillment(
            RedskyQueryMetadata metadata,
            String key,
            TcinList tcinList,
            TargetStore targetStore);

    /**
     * Submits a search query to target's redsky api. Search results include pricing.
     *
     * @param metadata values like channel, category, page and  customerId.
     * @param key api key for the redsky api, normally provided by an environment variable.
     * @param tcinList tcin ID's for products to query
     * @param targetStore store from which the product summaries are to be queried.
     * @return Search object in an ApiResponseData object, wrapped in an HttpResponse.
     */
    @Get("/plp_search_v2" +
            "{?key}" +
            "{&metadata*}" +
            "{&tcinList*}" +
            "{&targetStore.id}")
    HttpResponse<ApiResponseData> plpSearch(
            RedskyQueryMetadata metadata,
            String key,
            TcinList tcinList,
            TargetStore targetStore);
}
