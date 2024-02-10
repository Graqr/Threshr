package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record RollingOperatingHours(
        @JsonProperty("main_hours") MainHours mainHours,
        @Nullable @JsonProperty("capability_hours")
        List<CapabilityHour> capabilityHours) {
}
