package com.graqr.threshr.model.redsky.product.pdp.client;


import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record PdpClientRoot(Data data) {
}
