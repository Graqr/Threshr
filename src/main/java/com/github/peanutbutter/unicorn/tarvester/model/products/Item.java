package com.github.peanutbutter.unicorn.tarvester.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Item(
        @JsonProperty("is_limited_time_offer") Boolean isLimitedTimeOffer,
        @JsonProperty("relationship_type_code") String relationshipTypeCode,
        @JsonProperty("product_description") ProductDescription productDescription,
        Enrichment enrichment,
        Fulfillment fulfillment,
        @JsonProperty("merchandise_classification") MerchandiseClassification merchandiseClassification,
        @JsonProperty("product_vendors") List<ProductVendor> productVendors,
        @JsonProperty("eligibility_rules") EligibilityRules eligibilityRules) {
}
