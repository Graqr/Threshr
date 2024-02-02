package com.graqr.threshr.model.queryparam;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Introspected
@Data
public class TargetStorePdpSearch {
    final String store_id;
    final String pricing_store_id;

    public TargetStorePdpSearch(TargetStore targetStore) {
        // if the below getters are not resolving, lombok annotations are not working in your ide
        // https://stackoverflow.com/a/27430992/12253607
        pricing_store_id = targetStore.getStoreId();
        store_id = targetStore.getStoreId();
    }
}
