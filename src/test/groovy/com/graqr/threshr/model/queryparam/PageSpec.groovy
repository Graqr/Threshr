package com.graqr.threshr.model.queryparam

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

@MicronautTest
class PageSpec extends Specification {


    def "test creating a page and re-assigning a page"() {
        given:
        Page page

        when:
        page = new Page("page")

        then:
        page.getPage() == ""

        where:
        pageValue << Arrays.asList('root', 'Fresh Groceries', '')


    }
}