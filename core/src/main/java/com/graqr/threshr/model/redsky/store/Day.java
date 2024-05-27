package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Day(
        @JsonProperty("is_open") Boolean isOpen,
        String date,
        @JsonProperty("day_name")
        String dayName,
        List<Hour> hours,
        @Nullable @JsonProperty("sequence_number")
        String sequenceNumber) {
}