package com.graqr.threshr

import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.queryparam.Tcin
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ThreshrSpec extends Specification {

    @Inject
    @Shared
    Threshr threshrController

    @Inject
    @Shared
    ThreshrClient threshrClient

    @Shared // TODO configure test data to be provided, not hardcoded
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

}