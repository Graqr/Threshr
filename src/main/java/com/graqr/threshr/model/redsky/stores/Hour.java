package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Serdeable
public record Hour(
        @JsonProperty("begin_time") String beginTime,
        @JsonProperty("end_date") String endDate,
        @JsonProperty("end_time") String endTime) {
}
