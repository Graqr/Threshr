package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Capability(@JsonProperty("capability_code") String capabilityCode,
                         @JsonProperty("capability_name") String capabilityName,
                         @JsonProperty("effective_date") String effectiveDate) {}
