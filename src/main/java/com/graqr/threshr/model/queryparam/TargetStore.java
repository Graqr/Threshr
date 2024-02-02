package com.graqr.threshr.model.queryparam;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.QueryValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Introspected
public class TargetStore {
    @QueryValue("store_id")
    String storeId;

    @QueryValue("scheduled_delivery_store_id")
    String scheduledDeliveryStoreId;

    @QueryValue("required_store_id")
    String requiredStoreId;
    String zip, state;
    double latitude, longitude;

    public TargetStore(String locationId, String region, String postalCode, double latitude, double longitude) {
        storeId = locationId;
        scheduledDeliveryStoreId = locationId;
        requiredStoreId = locationId;
        zip = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        state = region;
    }
}
