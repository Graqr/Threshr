package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.context.annotation.Any;
import io.micronaut.core.annotation.Nullable;

import java.util.Map;

public record EligibilityRules(

        @Nullable Grocery grocery,

        @JsonProperty("available_to_purchase")
        AvailableToPurchase availableToPurchase,

        @JsonProperty("available_to_purchase_date_display")
        AvailableToPurchaseDateDisplay availableToPurchaseDateDisplay,

        @JsonProperty("available_to_purchase_time_display")
        AvailableToPurchaseTimeDisplay availableToPurchaseTimeDisplay,

        @JsonProperty("scheduled_delivery")
        ScheduledDelivery scheduledDelivery,

        @JsonProperty("loyalty_purchase")
        Map<String, Any> loyaltyPurchase
) {
}
