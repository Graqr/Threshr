package com.graqr.threshr

import com.graqr.threshr.model.queryparam.Place
import com.graqr.threshr.model.queryparam.Tcin
import com.graqr.threshr.model.redsky.product.Search
import com.graqr.threshr.model.redsky.store.NearbyStores
import com.graqr.threshr.model.redsky.store.Store
import groovy.sql.Sql
import io.micronaut.context.annotation.Value
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared

@MicronautTest
class ThreshrControllerSpec extends ThreshrSpec {

    @Shared
    @Value('${test.datasources.default.url}')
    String url

    @Shared
    Sql sql

    void setupSpec() {
        sql = Sql.newInstance(url)
    }

    void "null-bodied response from redsky is handled gracefully"() {
        when: "querying a non-existent tcin"
        threshrController.fetchProductSummaries(targetStore, "imAFakeTcin")

        then: "Threshr exception thrown"
        thrown(ThreshrException)
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

    void "query product summary for category #id returns expected data"() {
        when: "querying the #category_name category from #targetStore"
        Search search = threshrController.plpQuery(targetStore, (id as String).replace("N-", ""),0)

        then: "submitting query didn't throw any errors"
        noExceptionThrown()

        and: "Product array is not null"
        null != search.products()

        and: "Each product object contains non-null price object."
        search.products().collect { null != it.price() }

        where:
        [id, category_name] << sql.rows('select id, category_name from test_target_categories TABLESAMPLE BERNOULLI(10) LIMIT 5')
    }

    void "query product summary list for category #id returns expected data"() {
        when: "querying the #category_name category from #targetStore"
        List<Search> searches = threshrController.plpQuery(targetStore, (id as String).replace("N-", ""))

        then: "submitting query didn't throw any errors"
        noExceptionThrown()

        and: "List size matches pagination expected size."
        null != searches && searches.size() > 0 ? searches[0].searchResponse().metadata().totalPages() == searches.size() :
                "Expected list size " + searches.size() + " but got " + searches[0].searchResponse().metadata().totalPages()

        and: "Each product object contains non-null price object."
        searches.forEach {it.products().collect { null != it.price() }}

        where:
        [id, category_name] << sql.rows('select id, category_name from test_target_categories TABLESAMPLE BERNOULLI(10) LIMIT 1')
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