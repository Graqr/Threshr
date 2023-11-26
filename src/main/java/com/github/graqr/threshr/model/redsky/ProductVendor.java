package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductVendor(
        @JsonProperty("vendor_name")
        String vendorName,

        String id) {
}
