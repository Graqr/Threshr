package com.graqr

import groovy.sql.Sql
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class HarvesterSpec extends Specification {

    @Shared
    @Value('${test.datasources.default.url')
    String url

    @Shared
    Sql sql

    void setupSpec() {
        sql = Sql.newInstance(url)
    }

    void "calling a get request to /stores/target/#location_id returns data for #location_name"(
            @Client("/stores/target/") HttpClient client) {
        when:
        HttpResponse response = client.toBlocking().exchange(location_id as String, String)

        then:
        noExceptionThrown()
        response.status() == HttpStatus.OK

        where:
        [location_id, location_name, postal_code, latitude, longitude, city, region] << sql.rows('''
            SELECT location_id, location_name, postal_code, latitude, longitude, city, region
            FROM target_stores
            TABLESAMPLE BERNOULLI (20);'''.stripMargin())
    }

}
