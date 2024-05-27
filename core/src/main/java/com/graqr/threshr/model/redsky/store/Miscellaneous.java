package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Miscellaneous(@JsonProperty("google_cid") String googleCid) {}
