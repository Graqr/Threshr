package com.github.peanutbutter.unicorn.tarvester.model.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductDescription(String title) {
}
