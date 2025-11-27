package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable

@Serdeable
data class Price(
    @param:JsonProperty("formatted_current_price") val formattedCurrentPrice: String,
    @param:JsonProperty("formatted_current_price_type") val formattedCurrentPriceType: String,
    @param:JsonProperty("reg_retail") val regRetail: Double,
    @param:JsonProperty("formatted_unit_price") val formattedUnitPrice: String,
    @param:JsonProperty("formatted_unit_price_suffix") val formattedUnitPriceSuffix: String,
    @param:JsonProperty("location_id") val locationId: Long,
    @param:Nullable @param:JsonProperty("current_retail") val currentRetail: Double,
    @param:Nullable @param:JsonProperty("external_system_id") val externalSystemId: String,
    @param:Nullable @param:JsonProperty("is_current_price_range") val isCurrentPriceRange: Boolean
) {}
