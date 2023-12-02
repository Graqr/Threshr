package com.github.graqr.threshr.model.redsky.product.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.graqr.threshr.model.redsky.ProductSummary;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

/**
 * returned data from redsky api call.
 *
 * @param productSummary the returned object from the product_summary_with_fulfillment_v1 endpoint
 */
@Serdeable
public record Data(
        @JsonProperty("product_summaries")
        List<ProductSummary> productSummary
) {}


