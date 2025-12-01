package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Item(
    @param:Nullable @param:JsonProperty("cart_add_on_threshold") val cartAddOnThreshold: Double,
    val compliance: Compliance,
    @param:Nullable val disclaimer: Disclaimer,
    val dpci: String,
    @param:JsonProperty("eligibility_rules") val eligibilityRules: EligibilityRules,
    val enrichment: Enrichment,
    @param:Nullable @param:JsonProperty("environmental_segmentation") val environmentalSegmentation: EnvironmentalSegmentation,
    @param:Nullable @param:JsonProperty("formatted_return_method") val formattedReturnMethod: String,
    val fulfillment: Fulfillment,
    @param:Nullable val handling: Handling,
    @param:Nullable @param:JsonProperty("is_fresh_grocery") val isFreshGrocery: Boolean,
    @param:JsonProperty("is_limited_time_offer") val isLimitedTimeOffer: Boolean,
    @param:JsonProperty("merchandise_classification") val merchandiseClassification: MerchandiseClassification,
    @param:Nullable @param:JsonProperty("package_dimensions") val packageDimensions: PackageDimensions,
    @param:Nullable @param:JsonProperty("primary_barcode") val primaryBarcode: String,
    @param:JsonProperty("primary_brand") val primaryBrand: PrimaryBrand,
    @param:JsonProperty("product_classification") val productClassification: PrimaryBrand,
    @param:JsonProperty("product_description") val productDescription: ProductDescription,
    @param:JsonProperty("product_vendors") val productVendors: List<ProductVendor>,
    @param:JsonProperty("relationship_type_code") val relationshipTypeCode: String,
    @param:Nullable @param:JsonProperty("return_policies_guest_message") val returnPoliciesGuestMessage: String,
    @param:Nullable val ribbons: List<String>,
    @param:Nullable @param:JsonProperty("wellness_merchandise_attributes") val wellnessMerchandiseAttributes: List<Any>
) {}
