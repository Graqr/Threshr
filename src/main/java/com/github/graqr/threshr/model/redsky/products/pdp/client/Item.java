package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Item(
        @JsonProperty("cart_add_on_threshold") Double cartAddOnThreshold, Compliance compliance,
        Disclaimer disclaimer, String dpci,
        @JsonProperty("eligibility_rules") EligibilityRules eligibilityRules, Enrichment enrichment,
        @JsonProperty("environmental_segmentation") EnvironmentalSegmentation environmentalSegmentation,
        @JsonProperty("formatted_return_method") String formattedReturnMethod, Fulfillment fulfillment,
        Handling handling, @JsonProperty("is_fresh_grocery") Boolean isFreshGrocery,
        @JsonProperty("is_limited_time_offer") Boolean isLimitedTimeOffer,
        @JsonProperty("merchandise_classification") MerchandiseClassification merchandiseClassification,
        @JsonProperty("package_dimensions") PackageDimensions packageDimensions,
        @JsonProperty("primary_barcode") String primaryBarcode,
        @JsonProperty("primary_brand") PrimaryBrand primaryBrand,
        @JsonProperty("product_classification") ProductClassification productClassification,
        @JsonProperty("product_description") ProductDescription productDescription,
        @JsonProperty("product_vendors") List<ProductVendor> productVendors,
        @JsonProperty("relationship_type_code") String relationshipTypeCode,
        @JsonProperty("return_policies_guest_message") String returnPoliciesGuestMessage,
        List<String> ribbons,
        @JsonProperty("wellness_merchandise_attributes") List<?> wellnessMerchandiseAttributes) {
}
