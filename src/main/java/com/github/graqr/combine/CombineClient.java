package com.github.graqr.combine;

import com.github.graqr.combine.model.TargetStore;
import com.github.graqr.combine.model.TcinList;
import com.github.graqr.combine.model.products.Products;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Client(id = "redsky-api")
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
public interface CombineClient {
    @Get("/product_summary_with_fulfillment_v1{?key}{&tcinList*}{&targetStore*}&channel=WEB")
    HttpResponse<Products> productSummaryWithFulfillment(String key, TcinList tcinList, TargetStore targetStore);
}
