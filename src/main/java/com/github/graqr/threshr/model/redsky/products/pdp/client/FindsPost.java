package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record FindsPost(String id, String caption, String url,
                        @JsonProperty("placeholder_color")
                        String placeholderColor,
                        User user,
                        Image image) {
}
