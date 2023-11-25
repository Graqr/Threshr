package com.github.graqr.threshr;

import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest(startApplication = false)
@Property(name = "datasources.default.driver-class-name",
        value = "org.testcontainers.jdbc.ContainerDatabaseDriver")
@Property(name = "datasources.default.url",
        value = "jdbc:tc:postgresql:15.2-alpine:///db?TC_INITSCRIPT=db/migration/V1__create-schema.sql")
//@Sql(scripts = "classpath:db/migration/V1__create-schema.sql", phase = Sql.Phase.BEFORE_EACH)
public class SiloControllerTest extends ThreshrTest {

//    @Test
//    void testItWorks(SiloController siloController) {
//        Arrays.stream(products).forEach(siloController::insert);
//    }
}
