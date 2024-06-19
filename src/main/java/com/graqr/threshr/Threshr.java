package com.graqr.threshr;

import com.graqr.threshr.model.queryparam.Page;
import com.graqr.threshr.model.queryparam.Place;
import com.graqr.threshr.model.queryparam.TargetStore;
import com.graqr.threshr.model.queryparam.Tcin;
import com.graqr.threshr.model.redsky.product.Product;
import com.graqr.threshr.model.redsky.product.ProductSummaryWithFulfillment;
import com.graqr.threshr.model.redsky.store.NearbyStores;
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

    /**
     * Query product summaries and their fulfillment options. See {@link ProductSummaryWithFulfillment}
     *
     * @param targetStore TargetStore object whose inventory is queried for product summaries
     * @param tcin TCIN object for one or many product ID(s)
     * @return List of product summaries, one for each ID in the tcin object.
     * @throws ThreshrException if no product summaries are returned by the query
     */
    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummaryWithFulfillment> fetchProductSummaries(TargetStore targetStore, Tcin tcin) throws ThreshrException {
        return checkForNull(threshrClient.getProductSummary(targetStore, tcin))
                .data()
                .productSummaryWithFulfillmentList();
    }

    /**
     * Query product summaries and their fulfillment options. See {@link ProductSummaryWithFulfillment}
     *
     * @param targetStore TargetStore object whose inventory is queried for product summaries
     * @param tcin single or many string values for product ID(s)
     * @return List of product summaries, one for each ID in the tcin object.
     * @throws ThreshrException if no product summaries are returned by the query
     */
    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummaryWithFulfillment> fetchProductSummaries(TargetStore targetStore, String... tcin) throws ThreshrException {
        return fetchProductSummaries(targetStore, new Tcin(tcin));
    }

    /**
     * Queries the product details page for a given product at a given store.
     *
     * @param pricingStoreId 4-digit target store identifier
     * @param storeId 4-digit target store identifier
     * @param tcin Target's internal product id number. aka 'Target Catalog Identification Number'
     * @return Product object matching the given query
     * @throws ThreshrException if no Product matching given query is found
     */
    @Get("/product/details")
    @SingleResult
    public Product fetchProductDetails(String pricingStoreId, String storeId, String tcin) throws ThreshrException {
        return checkForNull(threshrClient.getProductDetails(pricingStoreId, storeId, tcin))
                .data()
                .product();
    }

    /**
     * queries at most 5 stores within 100 miles of a given location
     *
     * @param place Either a zipcode or a city-state pair of strings. see {@link Place}.
     * @return NearbyStores object with a list of store objects
     * @throws ThreshrException if the returned value is null.
     */
    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStores getStores(Place place) throws ThreshrException {
        return getStores(5, 100, place);
    }

    /**
     * Queries stores relative to a given location
     *
     * @param place Either a zipcode or a city-state pair of strings. see {@link Place}.
     * @param limit max store locations to include in returned NearbyStores object.
     * @param within distance from given location to include in search.
     * @return NearbyStores object with a list of store objects
     * @throws ThreshrException if the returned value is null.
     */
    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStores getStores(int limit, int within, Place place) throws ThreshrException {
        return checkForNull(threshrClient.getNearbyStores(limit, within, place.getZipOrCityState()))
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
        return checkForNull(threshrClient.getStore(storeId, channel, page.getName())).data().store();
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
            throw new ThreshrException("response body is null or of an unexpected type.\n" + response);
        }
        return response.body();
    }
}