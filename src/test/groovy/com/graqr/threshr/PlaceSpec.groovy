package com.graqr.threshr


import com.graqr.threshr.model.queryparam.Place
import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class PlaceSpec extends ThreshrSpec {

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

