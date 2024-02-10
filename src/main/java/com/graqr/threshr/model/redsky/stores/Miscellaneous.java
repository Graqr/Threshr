package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Miscellaneous(@JsonProperty("google_cid") String googleCid) {}
