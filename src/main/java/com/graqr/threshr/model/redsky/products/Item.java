package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Item(
        @Nullable @JsonProperty("cart_add_on_threshold")
        Double cartAddOnThreshold,

        Compliance compliance,

        @Nullable Disclaimer disclaimer,

        String dpci,

        @JsonProperty("eligibility_rules")
        EligibilityRules eligibilityRules,

        Enrichment enrichment,

        @Nullable @JsonProperty("environmental_segmentation")
        EnvironmentalSegmentation environmentalSegmentation,

        @Nullable @JsonProperty("formatted_return_method")
        String formattedReturnMethod,

        Fulfillment fulfillment,

        @Nullable Handling handling,

        @Nullable @JsonProperty("is_fresh_grocery")
        Boolean isFreshGrocery,

        @JsonProperty("is_limited_time_offer")
        Boolean isLimitedTimeOffer,

        @JsonProperty("merchandise_classification")
        MerchandiseClassification merchandiseClassification,

        @Nullable @JsonProperty("package_dimensions")
        PackageDimensions packageDimensions,

        @Nullable @JsonProperty("primary_barcode") String primaryBarcode,

        @JsonProperty("primary_brand")
        PrimaryBrand primaryBrand,

        @JsonProperty("product_classification")
        ProductClassification productClassification,

        @JsonProperty("product_description")
        ProductDescription productDescription,

        @JsonProperty("product_vendors")
        List<ProductVendor> productVendors,

        @JsonProperty("relationship_type_code")
        String relationshipTypeCode,

        @Nullable @JsonProperty("return_policies_guest_message")
        String returnPoliciesGuestMessage,

        @Nullable List<String> ribbons,

        @Nullable @JsonProperty("wellness_merchandise_attributes")
        List<?> wellnessMerchandiseAttributes) {
}
