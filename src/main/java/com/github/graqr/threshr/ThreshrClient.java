package com.github.graqr.threshr;

import com.github.graqr.threshr.model.RedskyQueryMetadata;
import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.TcinList;
import com.github.graqr.threshr.model.redsky.ProductSummary;
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
    @Get("/product_summary_with_fulfillment_v1" +
            "{?key}" +
            "{&metadata.channel}" +
            "{&tcinList*}" +
            "{&targetStore*}")
    HttpResponse<ProductSummary> productSummaryWithFulfillment(
            RedskyQueryMetadata metadata,
            String key,
            TcinList tcinList,
            TargetStore targetStore);

    @Get("/plp_search_v2" +
            "{?key}" +
            "{&metadata*}" +
            "{&tcinList*}" +
            "{&targetStore.id}")
    HttpResponse<ProductSummary> plpSearch(
            RedskyQueryMetadata metadata,
            String key,
            TcinList tcinList,
            TargetStore targetStore);
}
