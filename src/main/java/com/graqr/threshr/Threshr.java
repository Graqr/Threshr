package com.graqr.threshr;

import com.graqr.threshr.model.queryparam.Place;
import com.graqr.threshr.model.queryparam.TargetStore;
import com.graqr.threshr.model.queryparam.TargetStorePdpSearch;
import com.graqr.threshr.model.queryparam.Tcin;
import com.graqr.threshr.model.redsky.products.Product;
import com.graqr.threshr.model.redsky.products.ProductSummary;
import com.graqr.threshr.model.redsky.stores.NearbyStores;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Objects;

@Controller()
public class Threshr {

    @Inject
    ThreshrClient threshrClient;

    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummary> fetchProductSummariesWithFulfillment(TargetStore targetStore, Tcin tcin) {
        return Objects.requireNonNull(threshrClient.productSummaryWithFulfillment(targetStore, tcin).body()).data().productSummary();
    }

    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummary> fetchProductSummariesWithFulfillment(TargetStore targetStore, String... tcin) throws ThreshrException {
        return fetchProductSummariesWithFulfillment(targetStore, new Tcin(tcin));
    }

    @Get("/product/details")
    @SingleResult
    public Product fetchProductDetails(TargetStore targetStore, String tcin) {
        return Objects.requireNonNull(threshrClient.productDetails(new TargetStorePdpSearch(targetStore), tcin).body()).data().product();
    }

    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStores queryStoreLocations(Place place) {
        return queryStoreLocations(3, 100, place);
    }

    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStores queryStoreLocations(int limit, int within, Place place) {
        return Objects.requireNonNull(threshrClient.queryNearbyStores(limit, within, place.getPlace()).body()).data().nearbyStores();
    }

}