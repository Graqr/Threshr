package com.graqr.threshr.circleStore.client

import io.micronaut.context.annotation.Requires
import io.micronaut.context.annotation.Value
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.ClientFilter
import io.micronaut.http.annotation.RequestFilter
import io.micronaut.http.uri.UriBuilder

/**
 * Adds the api key as a query value and an ACCEPT header
 *
 * @author Jonathan Zollinger
 * @since 0.1.0
 */
@ClientFilter(serviceId = ["circle-api"])
@Requires(property = "threshr.key")
class CircleClientFilter(
    @param:Value("\${threshr.key}") private val apiKey: String
) {

    @RequestFilter
    fun doFilter(request: MutableHttpRequest<*>) {
        val newUri = UriBuilder.of(request.uri).queryParam("key", apiKey).build()
        request.header(
            "ACCEPT",
            "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/png,image/svg+xml,*/*;q=0.8"
        )
        request.uri(newUri)
    }
}