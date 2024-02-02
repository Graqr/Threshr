package com.graqr.threshr.model.redsky.stores;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.List;

@Serdeable
public record MainHours(List<Day> days) {
}
