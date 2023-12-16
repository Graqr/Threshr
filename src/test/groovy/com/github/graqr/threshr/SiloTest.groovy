package com.github.graqr.threshr


import com.github.graqr.threshr.model.silo.HarvestedItem

class SiloTest extends ThreshrTest {

    void "can save new entries to silo db"() {
        when:
        HarvestedItem myItem = new HarvestedItem()
        siloRepository.insert(myItem)

        then:
        noExceptionThrown()
    }
}
