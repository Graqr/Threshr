package com.graqr.threshr.model.redsky.product

import groovy.sql.Sql
import io.micronaut.context.annotation.Value
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Collectors

@MicronautTest
class SearchRecommendationsSpec extends Specification {

    @Shared
    @Value('${test.datasources.default.url}')
    String url

    @Shared
    Sql sql

    @Shared
    RelatedCategory[] testCategories

    void setupSpec() {
        url = null != url ? url : System.getenv("TEST_DATASOURCES_DEFAULT_URL")
        sql = Sql.newInstance(url)
        testCategories = sql.rows('select id, category_name from test_target_categories limit 5')
                .stream().map(it ->
                new RelatedCategory(it.get('id') as String, it.get('category_name') as String))
    }

    void "equals function validates equality with multiple RelatedCategory objects field"() {
        given:
        SearchRecommendations recommendations = new SearchRecommendations(testCategories.first().title(), testCategories)

        when:
        recommendations == new SearchRecommendations(testCategories.first().title(), testCategories)

        then:
        noExceptionThrown()
    }

    void "equals function fails appropriately with single field differences"() {
        given:
        SearchRecommendations recommendations = new SearchRecommendations(testCategories.first().title(), testCategories)

        when:
        recommendations != new SearchRecommendations(title, categories as RelatedCategory[])

        then:
        noExceptionThrown()

        where:
        title                          | categories
        testCategories.first().title() | testCategories[0..3].toArray(RelatedCategory[]::new) //bad categories
        "I'm a bad title"              | testCategories
        "we're all wrong"              | testCategories[2..3].toArray(RelatedCategory[]::new)

    }

    def "HashCode matches with multiple RelatedCategory objects field"() {
        given:
        SearchRecommendations recommendations = new SearchRecommendations(testCategories.first().title(), testCategories)

        when:
        recommendations.hashCode() == new SearchRecommendations(testCategories.first().title(), testCategories).hashCode()

        then:
        noExceptionThrown()
    }

    void "HashCode method fails appropriately with singe field differences"() {
        given:
        SearchRecommendations recommendations = new SearchRecommendations(testCategories.first().title(), testCategories)

        when:
        recommendations != new SearchRecommendations(title, categories as RelatedCategory[])

        then:
        noExceptionThrown()

        where:
        title                          | categories
        testCategories.first().title() | testCategories[0..3].toArray(RelatedCategory[]::new) //bad categories
        "I'm a bad title"              | testCategories
        "we're all wrong"              | testCategories[2..3].toArray(RelatedCategory[]::new)
    }


    def "ToString"() {
        given:
        String expectedTitle = testCategories.first().title()
        SearchRecommendations recommendations = new SearchRecommendations(expectedTitle, categories)
        String expectedCategories = Arrays.stream(categories).map { it ->
            return "RelatedCategory[url=${((RelatedCategory) it).url()}, title=${((RelatedCategory) it).title()}]"
        }
                .collect(Collectors.joining(", "))

        when:
        recommendations.toString() == "SearchRecommendations[categoryId=${expectedTitle}, relatedCategories=[${expectedCategories}]]"

        then:
        noExceptionThrown()


        where:
        title                          | categories
        testCategories.first().title() | testCategories[0..3].toArray(RelatedCategory[]::new)
        testCategories.last().title()  | new RelatedCategory[]{testCategories[0]}
    }
}
