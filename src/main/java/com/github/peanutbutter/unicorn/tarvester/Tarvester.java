package com.github.peanutbutter.unicorn.tarvester;

import io.micronaut.http.uri.UriBuilder;

import java.net.URI;

public class Tarvester {
    protected enum REDSKY_API {
        PRODUCTS("/product_summary_with_fulfillment_v1");

        private final String uri;
        REDSKY_API(String path) {
            uri ="https://redsky.target.com/redsky_aggregations/v1/web_platform" + path;
        }

        @Override
        public String toString() {
            return uri;
        }
    }


}
