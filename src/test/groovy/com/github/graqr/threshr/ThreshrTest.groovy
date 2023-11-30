package com.github.graqr.threshr

import com.github.graqr.threshr.model.RedskyQueryMetadata
import com.github.graqr.threshr.model.TargetStore
import com.github.graqr.threshr.model.TcinList
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Value
import io.micronaut.context.env.Environment
import io.micronaut.http.HttpResponse
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

import java.util.function.Predicate

@MicronautTest
class ThreshrTest extends Specification {

    @Shared
    @Value('${micronaut.http.services.redsky-api.visitorId}')
    String visitorId

    @Inject
    @Shared
    ThreshrController threshrController

    @Inject
    @Shared
    ThreshrClient threshrClient

    @Shared
    ApplicationContext ctx

    @Shared
    TargetStore targetStore = new TargetStore(1750,
            "UT",
            "84014-1752",
            40.91825,
            -111.887)

    @Shared
    RedskyQueryMetadata metadata = new RedskyQueryMetadata(visitorId, "5q0f2", "WEB")

    @Shared
    String redskyToken = System.getenv("REDSKY_TOKEN")

    @Shared
    TcinList tcinList = new TcinList(12345678)

    @Shared
    Predicate<HttpResponse<?>> okResponse = response -> response.code() >= 200 && response.code() < 300

    void setupSpec() {
        ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
    }

    void cleanupSpec() {
        ctx.stop()
    }

}
