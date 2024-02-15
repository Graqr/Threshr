package com.graqr.threshr


import io.micronaut.core.io.ResourceLoader
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ThreshrUtils {

    @Inject
    ResourceLoader resourceLoader

    @Inject
    ObjectMapper mapper

    <T> T readFileToObject(String filepath, T t) {
        return mapper.readValue(getResourceFromFile(filepath), t.class) as T
    }

    /**
     *
     * @param filepath
     * @return
     */
    byte[] getResourceFromFile(String filepath) {
        try {
            return resourceLoader.getResourceAsStream(filepath).get().readAllBytes()
        } catch (NoSuchElementException e) {
            throw new ThreshrException(String.format("failed to load '%s'.", filepath), e)
        }
    }
}
