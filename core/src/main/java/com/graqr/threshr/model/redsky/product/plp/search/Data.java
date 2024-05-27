package com.graqr.threshr.model.redsky.product.plp.search;

import com.graqr.threshr.model.redsky.product.Search;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Search search) {
}
