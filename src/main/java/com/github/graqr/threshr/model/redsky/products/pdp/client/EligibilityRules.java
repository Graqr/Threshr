package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record EligibilityRules(
        @JsonProperty("add_on")
        AddOn addOn,
        Grocery grocery,
        Hold hold,
        @JsonProperty("inventory_notification_to_guest_excluded")
        InventoryNotificationToGuestExcluded inventoryNotificationToGuestExcluded,
        @JsonProperty("scheduled_delivery")
        ScheduledDelivery scheduledDelivery) {
}
