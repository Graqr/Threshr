package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
@Introspected
public record Store(String status,
                    @JsonProperty("store_id") String storeId,
                    @JsonProperty("location_name") String locationName,
                    Double distance,
                    @JsonProperty("main_voice_phone_number") String mainVoicePhoneNumber,
                    @JsonProperty("mailing_address") MailingAddress mailingAddress,
                    @JsonProperty("rolling_operating_hours") RollingOperatingHours rollingOperatingHours,
                    @Nullable Geofence geofence,
                    @Nullable List<Capability> capabilities,
                    @Nullable @JsonProperty("drive_up") DriveUp driveUp,
                    @Nullable @JsonProperty("contact_information") List<ContactInformation> contactInformation,
                    @Nullable @JsonProperty("physical_specifications") PhysicalSpecifications physicalSpecifications,
                    @Nullable @JsonProperty("geographic_specifications") GeographicSpecifications geographicSpecifications,
                    @Nullable Miscellaneous miscellaneous
){}
