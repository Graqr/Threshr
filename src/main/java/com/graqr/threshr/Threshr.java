package com.graqr.threshr;

import com.graqr.threshr.model.queryparam.Page;
import com.graqr.threshr.model.queryparam.Place;
import com.graqr.threshr.model.queryparam.TargetStore;
import com.graqr.threshr.model.queryparam.Tcin;
import com.graqr.threshr.model.redsky.product.Product;
import com.graqr.threshr.model.redsky.product.ProductSummary;
import com.graqr.threshr.model.redsky.store.NearbyStore;
import com.graqr.threshr.model.redsky.store.Store;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/constructor")
public class Threshr {

    private final ThreshrClient threshrClient;

    @Inject
    public Threshr(@SuppressWarnings("ClassEscapesDefinedScope") ThreshrClient threshrClient){
        this.threshrClient = threshrClient;
    }


    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummary> fetchProductSummaries(TargetStore targetStore, Tcin tcin) throws ThreshrException {
        return checkForNull(threshrClient.getProductSummary(targetStore, tcin))
                .data()
                .productSummary();
    }

    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummary> fetchProductSummaries(TargetStore targetStore, String... tcin) throws ThreshrException {
        return fetchProductSummaries(targetStore, new Tcin(tcin));
    }

    @Get("/product/details")
    @SingleResult
    public Product fetchProductDetails(String pricingStoreId, String storeId, String tcin) throws ThreshrException {
        return checkForNull(threshrClient.getProductDetails(pricingStoreId, storeId, tcin))
                .data()
                .product();
    }

    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStore queryStoreLocations(Place place) throws ThreshrException {
        return queryStoreLocations(5, 100, place);
    }

    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStore queryStoreLocations(int limit, int within, Place place) throws ThreshrException {
        return checkForNull(threshrClient.getNearbyStores(limit, within, place.getPlace()))
                .data()
                .nearbyStores();
    }

    /**
     * Get Store information by store ID.
     * Assigns sensible default values of 'WEB' and '/c/root' for channel and page parameters.
     *
     * @param storeId 4-digit unique id for a target store
     * @return Store object
     * @throws ThreshrException if body of HttpResponse is null
     */
    @Get("/stores/id")
    @SingleResult
    public Store getStore(String storeId) throws ThreshrException {
        return getStore(storeId, "WEB", new Page("root"));
    }

    /**
     * Get Store information by store ID.
     *
     * @param storeId 4-digit unique id for a target store
     * @param channel communication through which this api is being called.
     * @param page source web page on target.com where this api call originates
     * @return Store object
     * @throws ThreshrException if body of HttpResponse is null
     */
    @Get("/stores/id")
    @SingleResult
    public Store getStore(String storeId, String channel, Page page) throws ThreshrException {
        return checkForNull(threshrClient.getStore(storeId, channel, page.getPage())).data().store();
    }

    /**
     * Checks if the provided HttpResponse object has a null body and throws a ThreshrException if it does.
     *
     * @param <T> The type of object expected in the response body.
     * @param response The HttpResponse object to check.
     * @return The body of the HttpResponse object if it's not null.
     * @throws ThreshrException If the response body is null.
     */
    private <T> T checkForNull(HttpResponse<T> response) throws ThreshrException {
        if (null == response.body()) {
            throw new ThreshrException(String.format("response body of HttpResponse<%s> is null", response
                    .body()
                    .getClass()
                    .getName()));
        }
        return response.body();
    }
}