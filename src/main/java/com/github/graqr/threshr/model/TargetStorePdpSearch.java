package com.github.graqr.threshr.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Introspected
@Data
public class TargetStorePdpSearch {
    final String store_id;
    final String pricing_store_id;

    public TargetStorePdpSearch(TargetStore targetStore) {
        pricing_store_id = targetStore.getStoreId();
        store_id = targetStore.getStoreId();
    }
}
