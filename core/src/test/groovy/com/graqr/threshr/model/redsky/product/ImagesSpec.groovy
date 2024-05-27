package com.graqr.threshr.model.redsky.product


import com.graqr.threshr.model.redsky.product.pdp.client.PdpClientRoot
import groovy.sql.Sql
import io.micronaut.context.annotation.Value
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import net.datafaker.Faker
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Stream

@MicronautTest
class ImagesSpec extends Specification {

    @Shared
    @Value('${test.datasources.default.url}')
    String url

    @Shared
    Sql sql

    @Shared
    String sqlStatement = "select response_body from test_target_response_objects where endpoint = 'pdp_client_v1'"

    @Inject
    @Shared
    ObjectMapper mapper

    @Shared
    Faker faker

    @Shared
    Images expectedImages

    void setupSpec() {
        url = null != url ? url : System.getenv("TEST_DATASOURCES_DEFAULT_URL")
        sql = Sql.newInstance(url)
        faker = new Faker()
        expectedImages = sql.rows(sqlStatement)
                .stream()
                .map(it -> mapper
                        .readValue((it."response_body" as String), PdpClientRoot)
                        .data()
                        .product()
                        .item()
                        .enrichment()
                        .images())
                .toList()
                .first()
    }

    void "Equals appropriately compares self and identical object"() {
        when:
        images == images

        then:
        noExceptionThrown()

        where:
        images << sql.rows(sqlStatement).stream().map(it ->
                mapper.readValue((it."response_body" as String), PdpClientRoot)
                        .data()
                        .product()
                        .item()
                        .enrichment()
                        .images()).toList()
    }

    void "images object to similar object with changed #alteredProperty"() {
        when:
        expectedImages != alteredImages

        then:
        noExceptionThrown()

        where:
        alteredImages                                                                                | alteredProperty
        new Images(
                expectedImages.primaryImageUrl(),
                Collections.nCopies(4, URL.newInstance(faker.internet().url())).toArray(URL[]::new),
                expectedImages.baseUrl(),
                expectedImages.primaryImage(),
                expectedImages.alternateImages(),
                expectedImages.contentLabels())                                                      | "alternateImageUrls"
        new Images(
                expectedImages.primaryImageUrl(),
                expectedImages.alternateImageUrls(),
                expectedImages.baseUrl(),
                expectedImages.primaryImage(),
                List.of(expectedImages.alternateImages().first()),
                expectedImages.contentLabels())                                                      | "alternateImages"
        new Images(
                expectedImages.primaryImageUrl(),
                expectedImages.alternateImageUrls(),
                expectedImages.baseUrl(),
                expectedImages.primaryImage(),
                expectedImages.alternateImages(),
                Stream.concat(Stream.of(new ContentLabel(faker.internet().url())),
                        expectedImages.contentLabels().stream()).toList())                           | "contentLabels"
        "I'm not an images object"                                                                   | "class"
    }

    void "Hashcode matches between identical object"() {
        when:
        images.hashCode() == images.hashCode()

        then:
        noExceptionThrown()

        where:
        images << sql.rows(sqlStatement).stream().map(it ->
                mapper.readValue((it."response_body" as String), PdpClientRoot)
                        .data()
                        .product()
                        .item()
                        .enrichment()
                        .images()).toList()
    }

    void "images object hashes do not match with the property #alteredProperty altered"() {
        when:
        expectedImages.hashCode() != alteredImages.hashCode()

        then:
        noExceptionThrown()

        where:
        alteredImages                                                                                | alteredProperty
        new Images(
                expectedImages.primaryImageUrl(),
                Collections.nCopies(4, URL.newInstance(faker.internet().url())).toArray(URL[]::new),
                expectedImages.baseUrl(),
                expectedImages.primaryImage(),
                expectedImages.alternateImages(),
                expectedImages.contentLabels())                                                      | "alternateImageUrls"
        new Images(
                expectedImages.primaryImageUrl(),
                expectedImages.alternateImageUrls(),
                expectedImages.baseUrl(),
                expectedImages.primaryImage(),
                List.of(expectedImages.alternateImages().first()),
                expectedImages.contentLabels())                                                      | "alternateImages"
        new Images(
                expectedImages.primaryImageUrl(),
                expectedImages.alternateImageUrls(),
                expectedImages.baseUrl(),
                expectedImages.primaryImage(),
                expectedImages.alternateImages(),
                Stream.concat(Stream.of(new ContentLabel(faker.internet().url())),
                        expectedImages.contentLabels().stream()).toList())                           | "contentLabels"
        "I'm not an images object"                                                                   | "class"
    }

}
