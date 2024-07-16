package com.graqr.threshr

import com.graqr.threshr.model.queryparam.Place
import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.queryparam.Tcin
import com.graqr.threshr.model.redsky.store.NearbyStores
import com.graqr.threshr.model.redsky.store.Store
import io.micronaut.context.annotation.Value
import io.micronaut.test.annotation.Sql
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
//@Property(name = "datasources.default.dialect", value = "postgresql")
//@Property(name = "datasources.default.driverClassName", value = "postgresql")
//@Property(name = "datasources.default.schema-generate", value = "CREATE_DROP")
//@Property(name = "datasources.default.url", value = "jdbc:postgresql://localhost:5432/postgres")
@Sql(scripts = ["classpath:/db/V1__create-target-categories.sql",
        "classpath:/db/V1__create-target-pdp.sql",
        "classpath:/db/V1__create-target-stores.sql",
        "classpath:/db/V2__populate-target-categories.sql",
        "classpath:/db/V2__populate-target-pdp.sql",
        "classpath:/db/V2__populate-target-stores.sql"], phase = Sql.Phase.BEFORE_ALL )
class ThreshrControllerSpec extends Specification {

    @Inject
    @Shared
    Threshr threshrController

    @Shared
    @Value('${datasources.default.url}')
    String testDataUrl

    @Shared
    groovy.sql.Sql sql

    @Shared
    def String targetStoreQuery = { Integer sample, Integer size ->
        """
select location_id, 
postal_code, 
latitude, 
longitude, 
region FROM target_stores where is_test_location = false TABLESAMPLE BERNOULLI (${sample}) LIMIT ${size}"""
    }

    void setupSpec() {
        sql = groovy.sql.Sql.newInstance(testDataUrl)
    }

    void "null-bodied response from redsky is caught in a ThreshrException"() {
        when: "querying a non-existent tcin"
        TargetStore targetStore = new TargetStore(
                locationId as String,
                region as String,
                postalCode as String,
                latitude as double,
                longitude as double
        )
        threshrController.fetchProductSummaries(targetStore, badTcin)

        then: "Threshr exception thrown"
        thrown(ThreshrException)

        where:
        badTcin                      | _
        "0123456789ABCDEF01234567"   | _ // Valid hexadecimal TCIN
        "ABCDE1234567890ABCDE1234"   | _ // Valid alphanumeric TCIN
        ""                           | _ //
        null                         | _ //
        "12345"                      | _ // Too short
        "123456789012345678901234!"  | _ // Invalid character
        "  1234567890  "             | _ // Leading trailing spaces
        "000000000000000000000000"   | _ // All zeros
        "111111111111111111111111"   | _ // All ones
        "12345678901234567890123456" | _ //  Overflow
        "';DROP TABLE target-pdp;"   | _ // SQL injection attempt
        [locationId, postalCode, latitude, longitude, city, region] << sql.rows(targetStoreQuery(10, 10) as String)
    }

    void "query pdp for #tcinArg tcin strings"() {
        when:
        if (count == 1) {
            threshrController.fetchProductSummaries(targetStore, tcinArg as String)
        } else {
            threshrController.fetchProductSummaries(targetStore, tcinArg as String[])
        }

        then:
        noExceptionThrown()

        where:
        tcinArg                       | count
        tcin.getTcins().split(",")[0] | 1
        tcin.getTcins().split(",")    | 2

    }

    void "query product summaries with no error tcin type arg"() {
        when:
        threshrController.fetchProductSummaries(targetStore, tcinArg)

        then:
        noExceptionThrown()

        where:
        tcinArg                                 | _
        tcin                                    | _
        new Tcin(tcin.getTcins().split(",")[0]) | _
    }

    void "query product details with no error"() {
        when:
        threshrController.fetchProductDetails(
                targetStore.storeId,
                targetStore.storeId,
                tcin.getTcins().split(",")[0]
        )

        then:
        noExceptionThrown()
    }

    void "test querying store number #location_id returns all data needed for other api endpoints"() {
        when:
        Store store = threshrController.getStore(location_id as String)

        then:
        location_id as String == store.storeId()
        location_name as String == store.locationName()
        postal_code as String == store.mailingAddress().postalCode()
        latitude as Double == store.geographicSpecifications().latitude()
        longitude as Double == store.geographicSpecifications().longitude()
        city as String == store.mailingAddress().city()
        region as String == store.mailingAddress().region()


        where:
        [location_id, location_name, postal_code, latitude, longitude, city, region] << sql.rows(
                'select location_id, location_name, postal_code, latitude, longitude, city, region FROM target_stores LIMIT 20')
    }

    void "test query store locations based on a Place object derived from a zipcode"() {
        when:
        NearbyStores stores = threshrController.getStores(testPlace)

        and:
        stores.stores().first().storeId() == location_id

        then:
        noExceptionThrown()

        where:
        [location_id, location_name, postal_code, latitude, longitude, city, region] << sql.rows(
                'select location_id, location_name, postal_code, latitude, longitude, city, region FROM target_stores LIMIT 20')
        testPlace = new Place(city as String, region as String)
    }
}