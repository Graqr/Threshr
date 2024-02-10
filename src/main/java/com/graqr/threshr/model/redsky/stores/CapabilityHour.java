package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CapabilityHour(@JsonProperty("capability_code") String capabilityCode,
                             List<Day> days) {
}
