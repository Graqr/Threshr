package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Serdeable
public record RollingOperatingHours(@JsonProperty("main_hours") MainHours mainHours) {
}
