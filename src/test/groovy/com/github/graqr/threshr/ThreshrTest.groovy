package com.github.graqr.threshr


import com.github.graqr.threshr.model.TargetStore
import com.github.graqr.threshr.model.Tcin
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.http.HttpResponse
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

import java.util.function.Predicate

@MicronautTest
class ThreshrTest extends Specification {

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
    Tcin tcin = new Tcin(
            new String[]{"82691535", "12953464"} //corn & coke https://bit.ly/45V8dui https://bit.ly/40j4A0e
    )

    @Shared
    Predicate<HttpResponse<?>> okResponse = response -> response.code() >= 200 && response.code() < 300

    void setupSpec() {
        ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
    }

    void cleanupSpec() {
        ctx.stop()
    }

}