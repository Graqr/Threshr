package com.github.peanutbutter.unicorn.tarvester;

import com.github.peanutbutter.unicorn.tarvester.model.TargetStore;
import com.github.peanutbutter.unicorn.tarvester.model.TcinList;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class TarvesterControllerTest {
    long[] realTcinIds = new long[]{82691535, 82642843, 85813668, 54556735, 78832377, 54556309, 54560630, 82628083,
            54558699, 54571053, 54567240, 87533518, 14917318, 85804763, 77788700, 54560287, 54535980, 54516414,
            82667184, 54530931, 54553288, 85825253, 54535968, 54556767};
    TargetStore targetStore = new TargetStore(
            "1750",
            "Centerville",
            "STORE",
            "200 N Market Place Dr",
            "Centerville",
            "UT",
            "84014-1752",
            "40.91825",
            "-111.887",
            "true",
            false,
            "8012920071",
            "false"
    );


    @Inject
    TarvesterController tarvesterController;

    @Test
    void fetchProducts() {
        HttpResponse<List<?>> response = tarvesterController.fetchProducts(new TcinList(new long[]{82691535L}),
                targetStore);
        assertTrue(200 <= response.code() && response.code() < 300, "response code from http request was not a success." +
                "Response reason includes: \"" + response.reason() + "\"");
    }
}