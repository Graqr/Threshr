package com.github.graqr.threshr.model.redsky.products.plp.search;

import com.github.graqr.threshr.model.redsky.products.Search;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Search search) {
}
