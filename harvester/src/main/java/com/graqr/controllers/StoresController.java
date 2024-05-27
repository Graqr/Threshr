package com.graqr.controllers;

import com.graqr.threshr.Threshr;
import com.graqr.threshr.ThreshrException;
import com.graqr.threshr.model.redsky.store.Store;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/stores")
public class StoresController {

    Threshr threshr;

    public StoresController(Threshr threshr) {
        this.threshr = threshr;
    }

    @Get("/target/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Store storeLocation(int id){
        try {
            return threshr.getStore(String.valueOf(id));
        } catch (ThreshrException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
