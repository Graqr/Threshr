package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Rating(
        Double average,
        Long count,

        @JsonProperty("secondary_averages")
        List<SecondaryAverage> secondaryAverages
) {
}
