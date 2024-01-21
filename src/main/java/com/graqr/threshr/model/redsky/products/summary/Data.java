package com.graqr.threshr.model.redsky.products.summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graqr.threshr.model.redsky.products.ProductSummary;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Data(@JsonProperty("product_summaries") List<ProductSummary> productSummary) {

}


