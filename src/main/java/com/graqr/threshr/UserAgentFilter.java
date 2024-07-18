package com.graqr.threshr;

import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.ClientFilter;
import io.micronaut.http.annotation.RequestFilter;

@ClientFilter("/**")
public class UserAgentFilter {
    @RequestFilter
    public void doFilter(MutableHttpRequest<?> request) {
        request.header("User-Agent", Utils.getSecureRandomString(32));
    }
}
