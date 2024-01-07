package com.github.graqr.threshr


import com.github.graqr.threshr.model.silo.Purchasable
import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class SiloTest extends ThreshrTest {

    void "can save new entries to silo db"() {
        when:
        Purchasable myItem = new Purchasable()
        siloRepository.save(myItem)

        then:
        noExceptionThrown()
    }
}
