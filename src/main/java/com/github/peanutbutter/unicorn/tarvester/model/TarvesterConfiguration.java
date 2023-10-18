package com.github.peanutbutter.unicorn.tarvester.model;

import io.micronaut.core.annotation.Nullable;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TarvesterConfiguration {
    @NotNull String token;
    @Nullable String visitorId, cookie;
}
