package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CapabilityHour(@JsonProperty("capability_code") String capabilityCode,
                             List<Day> days) {
}
