package com.github.graqr.combine.model;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Introspected
public class TargetStore {

    int store_id, scheduled_delivery_store_id, required_store_id;
    String zip, state;
    double latitude, longitude;

    public TargetStore(int locationId, String region, String postalCode, double latitude, double longitude) {
        store_id = locationId;
        scheduled_delivery_store_id = locationId;
        required_store_id = locationId;
        zip = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        state = region;
    }
}
