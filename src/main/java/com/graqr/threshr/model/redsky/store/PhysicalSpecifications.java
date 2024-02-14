package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PhysicalSpecifications(@JsonProperty("total_building_area") Long totalBuildingArea,
                                     @JsonProperty("merchandise_level") Long merchandiseLevel,
                                     String format) {}
