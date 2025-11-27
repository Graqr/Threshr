package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Fulfillment(
    @param:Nullable @param:JsonProperty("is_gift_wrap_eligible") val isGiftWrapEligible: Boolean,
    @param:Nullable @param:JsonProperty("purchase_limit") val purchaseLimit: Long,
    @param:Nullable @param:JsonProperty("product_id") val productId: String,
    @param:Nullable @param:JsonProperty("is_out_of_stock_in_all_store_locations") val isOutOfStockInAllStoreLocations: Boolean,
    @param:Nullable @param:JsonProperty("sold_out") val soldOut: Boolean,
    @param:Nullable @param:JsonProperty("shipping_options") val shippingOptions: ShippingOptions,
    @param:Nullable @param:JsonProperty("store_options") val storeOptions: List<StoreOption>,
    @param:Nullable @param:JsonProperty("scheduled_delivery") val scheduledDeliver: ScheduledDelivery
) {}
