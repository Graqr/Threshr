package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record CapabilityHour(@JsonProperty("capability_code") String capabilityCode,
                             List<Day> days) {
}
