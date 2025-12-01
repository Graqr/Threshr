package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class NutritionFacts(
    val ingredients: String,
    @param:JsonProperty("nutrition_label_type_code") val nutritionLabelTypeCode: String,
    @param:JsonProperty("value_prepared_list") val valuePreparedList: List<ValuePreparedList>
) {}
