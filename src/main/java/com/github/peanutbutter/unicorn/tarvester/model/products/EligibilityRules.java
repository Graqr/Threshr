package com.github.peanutbutter.unicorn.tarvester.model.products;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record EligibilityRules(@Nullable Grocery grocery) {

}