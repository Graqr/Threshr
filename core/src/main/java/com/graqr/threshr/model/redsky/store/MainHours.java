package com.graqr.threshr.model.redsky.store;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record MainHours(List<Day> days) {
}
