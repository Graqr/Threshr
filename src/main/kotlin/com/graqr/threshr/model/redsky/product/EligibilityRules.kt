package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class EligibilityRules(
    @param:JsonProperty("add_on") val addOn: AddOn,
    val grocery: Grocery,
    val hold: Hold,
    @param:JsonProperty("inventory_notification_to_guest_excluded") val inventoryNotificationToGuestExcluded: InventoryNotificationToGuestExcluded,
    @param:JsonProperty("scheduled_delivery") val scheduledDelivery: ScheduledDelivery
) {}
