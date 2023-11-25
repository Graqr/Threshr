package com.github.graqr.threshr;

import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.TcinList;
import com.github.graqr.threshr.model.targetProducts.Data;
import com.github.graqr.threshr.model.targetProducts.Root;
import io.micronaut.core.io.ResourceLoader;
import io.micronaut.http.HttpResponse;
import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@MicronautTest
public class ThreshrTest {
    @Inject
    ObjectMapper om;

    @Inject
    ResourceLoader rl;

    static TcinList tcinList;
    static TargetStore targetStore;
    String testApiKey = "9f36aeafbe60771e321a7cc95a78140772ab3e96";

    Predicate<HttpResponse<?>> okResponse = response -> response.code() >= 200 && response.code() < 300;
    Predicate<HttpResponse<Root>> productsCount = response -> 2 == Objects.requireNonNull(response.body())
            .data()
            .productSummary()
            .size();

    @BeforeAll
    static void setUp(SiloRepository dataRepository) {
        tcinList = new TcinList(new long[]{82691535, 12953464}); //corn & coke https://bit.ly/45V8dui https://bit.ly/40j4A0e
        targetStore = new TargetStore(
                1750,
                "UT",
                "84014-1752",
                40.91825,
                -111.887
        );
    }

    Data getSampleData(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        Optional<Root> root = resourceLoader
                .getResourceAsStream("product_summary_with_fulfillment_v1.json")
                .flatMap(inputStream -> {
                    try {
                        return Optional.ofNullable(objectMapper
                                .readValue(new String(
                                                inputStream.readAllBytes(),
                                                StandardCharsets.UTF_8),
                                        Root.class));
                    } catch (IOException e) {
                        return Optional.empty();
                    }
                });
        if (root.isEmpty()) {
            throw new CommandLine.PicocliException(
                    "failed to load test resource for tests in " + this.getClass().getName()
            );
        }
        return root.get().data();
    }
}
