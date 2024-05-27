package com.graqr.threshr.model.queryparam

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import net.datafaker.Faker
import spock.lang.Shared
import spock.lang.Specification

import java.util.function.Supplier
import java.util.stream.Collectors
import java.util.stream.Stream

@MicronautTest
class PlaceSpec extends Specification {

    @Shared
    Faker faker = new Faker()

    /**
     * @param supplier source for string values
     * @return list of 50 Strings
     */
    List<String> getDistinctList(Supplier<String> supplier) {
        return getDistinctList(supplier, 50)
    }

    /**
     * @param supplier source for string values
     * @param count list size to be returned
     * @return list of Strings of a given size.
     */
    List<String> getDistinctList(Supplier<String> supplier, int count) {
        return Stream.generate(supplier).distinct().limit(count).collect(Collectors.toList())
    }

    @Shared
    List<String> zipCodesPlus4 = getDistinctList(faker.address()::zipCodePlus4)

    @Shared
    List<String> zipCodes = getDistinctList(faker.address()::zipCode)

    @Shared
    List<String> cities = getDistinctList(faker.address()::cityName)

    @Shared
    List<String> states = getDistinctList(faker.address()::state)

    @Shared
    List<String> emptyStrings = Collections.nCopies(26, "").toList() + (Collections.nCopies(26, " "))

    void 'creating a Place object with "#badZipCode" throws an error'() {
        when:
        new Place(badZipCode)

        then:
        thrown(IllegalArgumentException)

        where:
        badZipCode << cities + List.of("", " ")
    }

    void 'creating a Place object with "#badCity" and "#badState" throws an error'() {
        when:
        new Place(badCity, badState)

        then:
        thrown(IllegalArgumentException)

        where:
        badCity << cities + emptyStrings
        badState << emptyStrings + states
    }

    void 'creating a Place object with "#goodZip" throws no error'() {
        when:
        new Place(goodZip)

        then:
        noExceptionThrown()

        where:
        goodZip << zipCodesPlus4 + zipCodes
    }

    void 'creating a Place object with "#goodCity" and "#goodState" throws no error'() {
        when:
        new Place(goodCity, goodState)

        then:
        noExceptionThrown()

        where:
        goodCity << cities
        goodState << states
    }
}

