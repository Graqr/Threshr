package com.github.graqr.threshr.model.targetProducts;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record EligibilityRules(@Nullable Grocery grocery) {

}
