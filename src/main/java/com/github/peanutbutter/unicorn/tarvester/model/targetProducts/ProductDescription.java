package com.github.peanutbutter.unicorn.tarvester.model.targetProducts;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductDescription(String title) {
}
