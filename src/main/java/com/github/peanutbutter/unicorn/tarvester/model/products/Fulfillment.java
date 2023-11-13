package com.github.peanutbutter.unicorn.tarvester.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Fulfillment(
        @Nullable
        @JsonProperty("product_id")
        String productId,
        @Nullable
        @JsonProperty("is_out_of_stock_in_all_store_locations")
        Boolean isOutOfStockInAllStoreLocations,
        @Nullable
        @JsonProperty("sold_out")
        Boolean soldOut,
        @Nullable
        @JsonProperty("shipping_options")
        ShippingOptions shippingOptions,
        @Nullable
        @JsonProperty("store_options")
        List<StoreOption> storeOptions,
        @Nullable
        @JsonProperty("scheduled_delivery")
        ScheduledDelivery scheduledDelivery) {
}
