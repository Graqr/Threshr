package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Enrichment(
    @param:JsonProperty("buy_url") val buyUrl: String,
    val images: Images,
    @param:JsonProperty("nutrition_facts") val nutritionFacts: NutritionFacts,
    val videos: List<Video>,
    @param:JsonProperty("return_policies") val returnPolicies: List<ReturnPolicy>
) {}
