package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record StoreOption(
        @JsonProperty("search_response_store_type")
        String searchResponseStoreType,
        @JsonProperty("location_available_to_promise_quantity")
        Double locationAvailableToPromiseQuantity,
        @JsonProperty("location_id")
        String locationId,
        Store store,
        @JsonProperty("order_pickup")
        OrderPickup orderPickup,
        @JsonProperty("in_store_only")
        InStoreOnly inStoreOnly) {

}
