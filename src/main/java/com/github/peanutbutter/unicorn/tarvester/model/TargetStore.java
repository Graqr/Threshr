package com.github.peanutbutter.unicorn.tarvester.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TargetStore {
    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("location_name")
    private String locationName;
    @JsonProperty("location_type")
    private String locationType;
    @JsonProperty("address_line_1")
    private String addressLine1;
    private String city;
    private String region;
    @JsonProperty("postal_code")
    private String postalCode;
    private String latitude;
    private String longitude;
    @JsonProperty("is_active")
    private String isActive;
    @JsonProperty("is_test_location")
    private Boolean isTestLocation;
    private String phone;
    @JsonProperty("obgb_enabled")
    private String obgbEnabled;
    public String toString() {
        return String.join("&", new String[]{
                "store_id=" + locationId,
                "zip=" + postalCode,
                "state=" + region,
                "latitude=" + latitude,
                "longitude=" + longitude,
                "scheduled_delivery_store_id=" + locationId,
                "required_store_id=" + locationId,
                "has_required_store_id=true"
        });
    }
}
