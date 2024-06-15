package com.graqr;

import com.graqr.threshr.Threshr;
import com.graqr.threshr.ThreshrException;
import com.graqr.threshr.model.queryparam.TargetStore;
import com.graqr.threshr.model.queryparam.Tcin;
import com.graqr.threshr.model.redsky.product.Product;
import com.graqr.threshr.model.redsky.store.Store;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;

@Singleton
@Command(name = "pdp", mixinStandardHelpOptions = true)
public class Pdp implements Runnable {

    private final Threshr threshr;
    @Option(names = {"--tcin", "-t"},
            required = true,
            description = "",
            converter = TcinsConverter.class)
    Tcin tcinValues;

    @Option(names = {"--store-id", "-s"},
            required = true,
            description = "store id as given in redsky api",
            converter = TargetStoreConverter.class)
    TargetStore store;

    @Inject
    ObjectMapper mapper;

    public Pdp(Threshr threshr) {
        this.threshr = threshr;
    }


    public static void main(String[] args) {
        PicocliRunner.run(Pdp.class, args);
    }

    public void run() {
        Product product;
        try {
            product = threshr.fetchProductDetails(store.getStoreId(), store.getStoreId(), tcinValues.getTcins());
        } catch (ThreshrException e) {
            throw new CommandLine.PicocliException("Failed to fetch product details", e);
        }
        try {
            System.out.println(mapper.writeValueAsString(product));
        } catch (IOException e) {
            throw new CommandLine.PicocliException("failed to write returned product as JSON", e);
        }
    }


    static class TargetStoreConverter implements CommandLine.ITypeConverter<TargetStore> {
        @Inject
        Threshr threshr;

        @Override
        public TargetStore convert(String s) throws ThreshrException {
            Store store = threshr.getStore(s);
            return new TargetStore(store.storeId(),
                    store.mailingAddress().state(),
                    store.mailingAddress().postalCode(),
                    store.geographicSpecifications().latitude(),
                    store.geographicSpecifications().longitude());
        }
    }

    static class TcinsConverter implements CommandLine.ITypeConverter<Tcin> {
        @Override
        public Tcin convert(String s) throws ThreshrException {
            if (s.split(",").length > 1) {
                throw new CommandLine.TypeConversionException("only one tcin can be provided");
            }
            return new Tcin(s);
        }
    }
}