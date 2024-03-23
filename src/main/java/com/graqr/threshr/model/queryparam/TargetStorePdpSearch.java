package com.graqr.threshr.model.queryparam;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.QueryValue;
import lombok.Data;

@Introspected
@Data
public class TargetStorePdpSearch {
    @QueryValue("store_id")
    final String storeId;
    @QueryValue("pricing_store_id")
    final String pricingStoreId;

    public TargetStorePdpSearch(TargetStore targetStore) {
        // if the below getters are not resolving, lombok annotations are not working in your ide
        // https://stackoverflow.com/a/27430992/12253607
        pricingStoreId = targetStore.getStoreId();
        storeId = targetStore.getStoreId();
    }
}
