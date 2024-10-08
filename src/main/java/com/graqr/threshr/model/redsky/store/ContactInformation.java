package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ContactInformation(@JsonProperty("building_area") String buildingArea,
                                 @JsonProperty("telephone_type") String telephoneType,
                                 @JsonProperty("is_international_phone_number") Boolean isInternationalPhoneNumber,
                                 @JsonProperty("telephone_number") String telephoneNumber,
                                 String capability) {}
