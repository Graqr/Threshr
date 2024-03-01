package com.graqr.threshr.model.queryparam

import com.graqr.threshr.ThreshrException
import io.micronaut.context.annotation.Value
import io.micronaut.core.io.ResourceLoader
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

import java.util.function.Function
import java.util.stream.Stream

@MicronautTest
class PageSpec extends Specification {

    @Shared
    @Value('${test.datasources.file.categories}')
    String pagesFilepath

    @Shared
    String[] expectedPages

    /**
     * Removes any trailing directories in the url.
     *
     * Example:
     * "/c/laundry-care-household-essentials/-/N-5xsyr" is trimmed to "/c/laundry-care-household-essentials"
     * "laundry-care-household-essentials/-/N-5xsyr" is trimmed to "laundry-care-household-essentials"
     *
     */
    @Shared
    Function<String, String> trimExcessPath = original -> {
        int endStart = original.trim().startsWith("/c/") ? 3 : 0
        return (original.substring(endStart).contains("/") ?
                original.substring(0, original.indexOf("/", endStart)) :
                original)
    }

    @Inject
    @Shared
    ResourceLoader resourceLoader

    String[] getLinesFromFile(String filepath) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(getResourceFromFile(filepath))) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream)) {
                try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                    return bufferedReader.lines().toArray(String[]::new)
                }
            }
        }
    }

    /**
     * Reads in a file as a byte array.
     *
     * @param filepath prepend "classpath:" if path is in test resource root dir
     * @return byte array of the file contents
     */
    byte[] getResourceFromFile(String filepath) {
        try {
            return resourceLoader.getResourceAsStream(filepath).get().readAllBytes()
        } catch (NoSuchElementException e) {
            throw new ThreshrException(String.format("failed to load '%s'. ", filepath) + e.getMessage(), e)
        }
    }

    def setupSpec() {
        expectedPages = getLinesFromFile("classpath:" + pagesFilepath)
    }


    def "test create new Page from #pageValue seed data creates object with expected value"() {
        given:
        pageValue = trimExcessPath.apply(pageValue as String)
        Page page

        when:
        page = new Page(pageValue) //assumed data has "/c/" prepended to string

        then:
        page.getPage() == pageValue

        and:
        page.setPage(pageValue.replace("/c/", ""))

        then:
        page.getPage() == pageValue

        where:
        pageValue << Stream.of(expectedPages).map(it -> {
            String tempPage = (it as String).trim()
            int start = tempPage.startsWith("/c/") ? 3 : 0
            if (tempPage.indexOf("/", start + 1)) {
                return tempPage.substring(0, tempPage.indexOf("/", start + 1))
            }
            return tempPage
        }).toArray(String[]::new)
    }
}