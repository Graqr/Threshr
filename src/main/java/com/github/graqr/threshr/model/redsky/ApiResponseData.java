package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Null;

import java.util.List;

/**
 * Generalized object type for all 'Data' objects returned from redsky api calls.
 *
 * @param productSummary the returned object from the product_summary_with_fulfillment_v1 endpoint
 * @param search the returned object from the plp_search_v2 endpoint.
 */
@Serdeable
public record ApiResponseData(

        @Nullable @JsonProperty("product_summaries")
        List<ProductSummary> productSummary,

        @Nullable
        Search search
) {}


