package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Serdeable
public record Store(String status, @JsonProperty("store_id") String storeId,
                    @JsonProperty("location_name") String locationName,
                    Double distance,
                    @JsonProperty("main_voice_phone_number") String mainVoicePhoneNumber,
                    @JsonProperty("mailing_address") MailingAddress mailingAddress,
                    @JsonProperty("rolling_operating_hours") RollingOperatingHours rollingOperatingHours) {
}
