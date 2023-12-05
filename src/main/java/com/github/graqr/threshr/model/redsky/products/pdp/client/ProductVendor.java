package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductVendor(
        String id,
        @JsonProperty("vendor_name")
        String vendorName) {
}
