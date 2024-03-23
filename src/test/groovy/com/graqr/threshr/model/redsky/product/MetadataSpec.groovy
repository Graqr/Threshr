package com.graqr.threshr.model.redsky.product

import net.datafaker.Faker
import spock.lang.Shared
import spock.lang.Specification

import java.util.function.Function
import java.util.stream.Collectors

class MetadataSpec extends Specification {

    @Shared
    Faker faker
    @Shared
    String[] responseIds
    @Shared
    int count, currentPage, offset, totalPages, totalResults
    @Shared
    String keyword, sortBy
    @Shared
    Map<String, String> sortOptions

    @Shared
    Function<Integer, Integer> randIntNot = num -> {
        def value = randInt
        return value != num ? value : randIntNot.apply(num as Integer)
    }

    int getRandInt() {
        return faker.number().randomDigitNotZero()
    }

    int getRandInt(int exclude) {
        def value = getRandInt()
        return value != exclude ? value : getRandInt()
    }

    void setupSpec() {
        faker = new Faker()
        def starWars = faker.starWars()
        responseIds = Collections.nCopies(getRandInt(), faker.idNumber().valid()).toArray(String[]::new)
        count = getRandInt()
        currentPage = getRandInt()
        keyword = starWars.wookieWords()
        offset = getRandInt()
        sortBy = starWars.quotes()
        totalPages = getRandInt()
        totalResults = getRandInt()
        sortOptions = Arrays.stream(Collections.nCopies(getRandInt(), starWars.character())).collect(
                Collectors.toMap(person -> (String) person, person -> starWars.quotes()))
    }

    void "equals validates self and identical metaData object match"() {
        given:
        Metadata metadata = new Metadata(
                responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)

        when:
        metadata == metadata

        and:
        metadata == new Metadata(
                responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)

        then:
        noExceptionThrown()
    }

    void "equals comparison between an object and itself fails after changing #changedObject"() {
        given:
        Metadata metadata = new Metadata(
                responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)

        when:
        metadata != nonMatchingMetada

        then:
        noExceptionThrown()

        where:
        nonMatchingMetada                                                                                               | changedObject
        new Metadata(Collections.nCopies(faker.number().randomDigitNotZero(), faker.idNumber().valid()).toArray(String[]::new),
                count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)                     | "responseIds"
        new Metadata(responseIds, (int) randIntNot.apply(count),
                currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)                            | "count"
        new Metadata(responseIds, count, getRandInt(currentPage),
                keyword, offset, sortBy, totalPages, totalResults, sortOptions)                                         | "currentPage"
        new Metadata(responseIds, count, currentPage, faker.chuckNorris().fact(),
                offset, sortBy, totalPages, totalResults, sortOptions)                                                  | "keyword"
        new Metadata(responseIds, count, currentPage, keyword, getRandInt(offset),
                sortBy, (totalPages), totalResults, sortOptions)                                                        | "offset"
        new Metadata(responseIds, count, currentPage, keyword, offset, faker.studioGhibli().quote(),
                totalPages, (totalResults), sortOptions)                                                                | "sortBy"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, getRandInt(totalPages),
                totalResults, sortOptions)                                                                              | "totalPages"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, getRandInt(totalResults),
                sortOptions)                                                                                            | "totalResults"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults,
                Arrays.stream(Collections.nCopies(getRandInt(), faker.studioGhibli().character())).collect(
                        Collectors.toMap(person -> (String) person, person -> faker.chuckNorris().fact())))             | "sortOptions"
        Map.of("responseIds", responseIds,
                "count", count,
                "currentPage", currentPage,
                "keyword", keyword,
                "offset", offset,
                "sortBy", sortBy,
                "totalPages", totalPages,
                "totalResults", totalResults,
                "sortOptions", sortOptions)                                                                             | "everything to a Map of values matching the original object"
        null                                                                                                            | "to a null value"
    }

    void "generated hashes of self and identical metaData object match"() {
        given:
        Metadata metadata = new Metadata(
                responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)

        when:
        metadata.hashCode() == metadata.hashCode()

        and:
        metadata.hashCode() == new Metadata(
                responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions).hashCode()

        then:
        noExceptionThrown()
    }

    void "generated hashes of self and foreign object altered in #changedObject do NOT match"() {
        given:
        int ogHash = new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults,
                sortOptions).hashCode()

        when:
        ogHash != nonMatchingMetada.hashCode()

        then:
        noExceptionThrown()

        where:
        nonMatchingMetada                                                                                               | changedObject
        new Metadata(Collections.nCopies(faker.number().randomDigitNotZero(), faker.idNumber().valid()).toArray(String[]::new),
                count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)                     | "responseIds"
        new Metadata(Collections.nCopies(faker.number().randomDigitNotZero(), null).toArray(String[]::new),
                count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)                     | "responseIds as null"
        new Metadata(responseIds, (int) randIntNot.apply(count),
                currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions)                            | "count"
        new Metadata(responseIds, count, getRandInt(currentPage),
                keyword, offset, sortBy, totalPages, totalResults, sortOptions)                                         | "currentPage"
        new Metadata(responseIds, count, currentPage, faker.chuckNorris().fact(),
                offset, sortBy, totalPages, totalResults, sortOptions)                                                  | "keyword"
        new Metadata(responseIds, count, currentPage, keyword, getRandInt(offset),
                sortBy, (totalPages), totalResults, sortOptions)                                                        | "offset"
        new Metadata(responseIds, count, currentPage, keyword, offset, faker.studioGhibli().quote(),
                totalPages, (totalResults), sortOptions)                                                                | "sortBy"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, getRandInt(totalPages),
                totalResults, sortOptions)                                                                              | "totalPages"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, getRandInt(totalResults),
                sortOptions)                                                                                            | "totalResults"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions
                .replace(((Map<String, String>) sortOptions)
                        .keySet()
                        .last(), faker.chuckNorris()
                        .fact()) as Map<String, String>)                                                                | "sortOptions via edit"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults,
                sortOptions.remove(sortOptions.keySet().last()) as Map<String, String>)                                 | "sortOptions via trim"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults,
                sortOptions.put(faker.studioGhibli().character(), faker.chuckNorris().fact()) as Map<String, String>)   | "sortOptions via appending"
        new Metadata(responseIds, count, currentPage, keyword, offset, sortBy, totalPages, totalResults,
                Arrays.stream(Collections.nCopies(getRandInt(), faker.studioGhibli().character())).collect(
                        Collectors.toMap(person -> (String) person, person -> faker.chuckNorris().fact())))             | "all of sort options"
        Map.of("responseIds", responseIds,
                "count", count,
                "currentPage", currentPage,
                "keyword", keyword,
                "offset", offset,
                "sortBy", sortBy,
                "totalPages", totalPages,
                "totalResults", totalResults,
                "sortOptions", sortOptions)                                                                             | "everything to a Map of values matching the original object"
    }
}
