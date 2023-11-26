package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.context.annotation.Any;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.Map;

@Serdeable
public record Item(
        @JsonProperty("is_limited_time_offer")
        Boolean isLimitedTimeOffer,

        @JsonProperty("relationship_type_code")
        String relationshipTypeCode,

        @JsonProperty("product_description")
        ProductDescription productDescription,

        Enrichment enrichment,

        Fulfillment fulfillment,

        @JsonProperty("merchandise_classification")
        MerchandiseClassification merchandiseClassification,

        @JsonProperty("product_vendors")
        List<ProductVendor> productVendors,

        @JsonProperty("eligibility_rules")
        EligibilityRules eligibilityRules,

        Map<String, Any> compliance,

        String dpci,

        @JsonProperty("mmbv_content")
        MmbvContent mmbvContent,

        @JsonProperty("cart_add_on_threshold")
        Double cartAddOnThreshold,

        @JsonProperty("primary_brand")
        PrimaryBrand primaryBrand,

        @JsonProperty("choking_hazard")
        List<ChokingHazard> chokingHazard,

        List<String> ribbons){
}
