package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Fulfillment(@JsonProperty("is_gift_wrap_eligible") Boolean isGiftWrapEligible,
                          @JsonProperty("purchase_limit") Long purchaseLimit) {
}
