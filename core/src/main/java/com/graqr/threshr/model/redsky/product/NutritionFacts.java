package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record NutritionFacts(
        String ingredients,
        @JsonProperty("nutrition_label_type_code") String nutritionLabelTypeCode,
        @JsonProperty("value_prepared_list") List<ValuePreparedList> valuePreparedList) {
}
