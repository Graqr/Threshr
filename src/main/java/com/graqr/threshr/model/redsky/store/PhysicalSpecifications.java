package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record PhysicalSpecifications(@JsonProperty("total_building_area") Long totalBuildingArea,
                                     @JsonProperty("merchandise_level") Long merchandiseLevel,
                                     String format) {}
