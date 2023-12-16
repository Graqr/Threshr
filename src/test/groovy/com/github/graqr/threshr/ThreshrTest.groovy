package com.github.graqr.threshr

import com.github.graqr.threshr.model.redsky.TargetStore
import com.github.graqr.threshr.model.redsky.Tcin
import com.github.graqr.threshr.model.redsky.api.Product
import com.github.graqr.threshr.model.redsky.api.pdp.client.Data
import io.micronaut.context.ApplicationContext
import io.micronaut.core.io.IOUtils
import io.micronaut.core.io.ResourceResolver
import io.micronaut.http.HttpResponse
import io.micronaut.serde.ObjectMapper
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

    @Inject
    @Shared
    SiloRepository siloRepository

    @Shared
    ApplicationContext ctx

    @Inject
    ObjectMapper objectMapper

    @Inject
    ResourceResolver resourceResolver

    @Shared
    Product testProduct

    @Shared
    TargetStore targetStore = new TargetStore(
            "1750",
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
        testProduct = getProductTestResource()
    }


    Product getProductTestResource() {
        return objectMapper
                .readValue(
                        IOUtils.readText(new BufferedReader(new InputStreamReader(
                                resourceResolver
                                        .getResource("classpath:example/response/pdp_client.json")
                                        .get()
                                        .openStream()
                        ))),
                        Data.class)
                .product()
    }

}