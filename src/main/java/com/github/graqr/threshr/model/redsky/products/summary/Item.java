package com.github.graqr.threshr.model.redsky.products.summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.graqr.threshr.model.redsky.products.plp.search.Compliance;
import com.github.graqr.threshr.model.redsky.products.plp.search.PrimaryBrand;
import com.github.graqr.threshr.model.redsky.products.plp.search.ProductClassification;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Item(
        @JsonProperty("cart_add_on_threshold")
        @Nullable Double cartAddOnThreshold,

        Compliance compliance,
        @Nullable String dpci,

        @JsonProperty("eligibility_rules")
        @Nullable EligibilityRules eligibilityRules,

        Enrichment enrichment,
        Fulfillment fulfillment,

        @JsonProperty("is_limited_time_offer")
        @Nullable Boolean isLimitedTimeOffer,

        @JsonProperty("merchandise_classification")
        @Nullable MerchandiseClassification merchandiseClassification,

        @JsonProperty("primary_brand")
        @Nullable PrimaryBrand primaryBrand,

        @JsonProperty("product_classification")
        @Nullable ProductClassification productClassification,

        @JsonProperty("product_description")
        @Nullable ProductDescription productDescription,

        @JsonProperty("product_vendors")
        @Nullable List<ProductVendor> productVendors,

        @JsonProperty("relationship_type_code")
        @Nullable String relationshipTypeCode) {
}
