package com.github.graqr.threshr.model.redsky.api.plp.search;

import com.github.graqr.threshr.model.redsky.api.Search;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Search search) {
}
