package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Serdeable
public record Day(
        @JsonProperty("is_open") Boolean isOpen,
        String date,
        @JsonProperty("day_name")
        String dayName,
        List<Hour> hours) {
}