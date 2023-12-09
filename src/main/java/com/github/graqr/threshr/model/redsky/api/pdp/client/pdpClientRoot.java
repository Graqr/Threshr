package com.github.graqr.threshr.model.redsky.api.pdp.client;


import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record pdpClientRoot(Data data) {
}
