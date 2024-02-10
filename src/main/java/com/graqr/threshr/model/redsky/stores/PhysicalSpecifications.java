package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PhysicalSpecifications(@JsonProperty("total_building_area") Long totalBuildingArea,
                                     @JsonProperty("merchandise_level") Long merchandiseLevel,
                                     String format) {}
