package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Capability(@JsonProperty("capability_code") String capabilityCode,
                         @JsonProperty("capability_name") String capabilityName,
                         @JsonProperty("effective_date") String effectiveDate) {}
