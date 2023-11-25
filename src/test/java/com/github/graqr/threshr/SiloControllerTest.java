package com.github.graqr.threshr;

import com.github.graqr.threshr.model.HarvestedProduct;
import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.util.Arrays;

@MicronautTest(startApplication = false)
@Property(name = "datasources.default.driver-class-name",
        value = "org.testcontainers.jdbc.ContainerDatabaseDriver")
@Property(name = "datasources.default.url",
        value = "jdbc:tc:postgresql:15.2-alpine:///db?TC_INITSCRIPT=db/migration/V1__create-schema.sql")
//@Sql(scripts = "classpath:db/migration/V1__create-schema.sql", phase = Sql.Phase.BEFORE_EACH)
public class SiloControllerTest extends ThreshrTest {

    @Test
    void testItWorks(SiloController siloController) {
        HarvestedProduct[] products = getSampleData(om, rl)
                .productSummary()
                .stream()
                .map(productSummary -> new HarvestedProduct(
                        null, Long.parseLong(productSummary.tcin()), productSummary.typename())
                ).toArray(HarvestedProduct[]::new);
        if (products.length < 1) {
            throw new CommandLine.PicocliException("no product summaries found in test resources sample data");
        }
        Arrays.stream(products).forEach(siloController::insert);
    }
}
