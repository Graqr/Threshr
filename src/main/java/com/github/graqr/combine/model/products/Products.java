package com.github.graqr.combine.model.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Products(Data data) {
}
