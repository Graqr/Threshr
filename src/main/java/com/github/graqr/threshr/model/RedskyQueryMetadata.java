package com.github.graqr.threshr.model;

import io.micronaut.http.annotation.QueryValue;
import jakarta.validation.constraints.Size;

public class RedskyQueryMetadata {
    @Size(min = 32, max = 32)
    @QueryValue("visitor_id")
    String visitorId;

    String category, page, channel;

    public RedskyQueryMetadata(String visitorId, String category, String channel) {
        this.visitorId = visitorId;
        this.category = category; //department?
        this.page = String.format("/c/%s", category);
        this.channel = channel.toUpperCase();
    }
}