package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Hour(
        @Nullable @JsonProperty("begin_date")
        String beginDate,
        @JsonProperty("begin_time") String beginTime,
        @JsonProperty("end_date") String endDate,
        @JsonProperty("end_time") String endTime) {
}
