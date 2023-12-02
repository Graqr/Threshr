package com.github.graqr.threshr.model.redsky.product.summary;

import com.github.graqr.threshr.model.redsky.Search;
import io.micronaut.serde.annotation.Serdeable;

/**
 * returned data from redsky api call.
 *
 * @param search the returned object from the plp_search_v2 endpoint.
 */
@Serdeable
public record Data(Search search) {
}


