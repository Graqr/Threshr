package com.github.graqr.threshr;

import com.github.graqr.threshr.model.products.ProductSummary;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.util.Arrays;

@MicronautTest
public class DbControllerTest extends ThreshrTest {

    @Test
    void testItWorks(DbController dbController) {
        ProductSummary[] products = getSampleData(om, rl).productSummary().toArray(new ProductSummary[0]);
        if (products.length < 1) {
            throw new CommandLine.PicocliException("no product summaries found in test resources sample data");
        }
        Arrays.stream(products).forEach(dbController::save);
    }
}
