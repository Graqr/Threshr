package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Serdeable
public record MailingAddress(
        @JsonProperty("address_line1") String addressLine1,
        String city,
        @JsonProperty("country_code") String countryCode,
        String region,
        String state,
        @JsonProperty("postal_code") String postalCode) {
}
