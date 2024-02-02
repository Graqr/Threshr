package com.graqr.threshr.model.queryparam


import io.micronaut.test.extensions.spock.annotation.MicronautTest
import net.datafaker.Faker
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.Stream

@MicronautTest
class PlaceSpec extends Specification {

    @Shared
    Faker faker = new Faker()
    @Shared
    List<String> zipCodesPlus4 = Stream.generate(faker.address()::zipCodePlus4).distinct().limit(50).collect(Collectors.toList())
    @Shared
    List<String> zipCodes = Stream.generate(faker.address()::zipCode).distinct().limit(50).collect(Collectors.toList())
    @Shared
    List<String> cities = Stream.generate(faker.address()::cityName).limit(50).collect(Collectors.toList())
    @Shared
    List<String> states = Stream.generate(faker.address()::state).limit(50).collect(Collectors.toList())
    @Shared
    List<String> emptyStrings = Collections.nCopies(26, "").toList() + (Collections.nCopies(26, " "))

    void 'test creating a Place object with "#badZipCode" throws an error'() {
        when:
        new Place(badZipCode)

        then:
        thrown(IllegalArgumentException)

        where:
        badZipCode << cities + List.of("", " ")
    }

    void 'test creating a Place object with "#badCity" and "#badState" throws an error'() {
        when:
        new Place(badCity, badState)

        then:
        thrown(IllegalArgumentException)

        where:
        badCity << cities + emptyStrings
        badState << emptyStrings + states
    }

    void 'test creating a Place object with "#goodZip" throws no error'() {
        when:
        new Place(goodZip)

        then:
        noExceptionThrown()

        where:
        goodZip << zipCodesPlus4 + zipCodes
    }

    void 'test creating a Place object with "#goodCity" and "#goodState" throws no error'() {
        when:
        new Place(goodCity, goodState)

        then:
        noExceptionThrown()

        where:
        goodCity << cities
        goodState << states
    }


}

