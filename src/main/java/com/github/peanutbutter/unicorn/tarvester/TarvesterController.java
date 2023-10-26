package com.github.peanutbutter.unicorn.tarvester;

import com.github.peanutbutter.unicorn.tarvester.model.TargetStore;
import com.github.peanutbutter.unicorn.tarvester.model.TcinList;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("products")
public class TarvesterController {

    final TarvesterClient tarvesterClient;

    public TarvesterController(TarvesterClient tarvesterClient) {
        this.tarvesterClient = tarvesterClient;
    }

    @Get("by-tcin")
    @SingleResult
    HttpResponse<List<?>> fetchProducts(TcinList tcinlist, TargetStore targetStore) {
        return tarvesterClient.fetchProducts(tcinlist.toString(), targetStore.toString());
    }
}
