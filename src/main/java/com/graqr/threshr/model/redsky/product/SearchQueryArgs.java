package com.graqr.threshr.model.redsky.product;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import lombok.Data;

@Introspected
@Data
public class SearchQueryArgs {
    // --- required fields ---
    String member_id, channel, category;
    boolean new_search;
    int offset;

    // --- not required fields ---
    @Nullable
    String page;
    @Nullable
    Boolean is_bot;
    @Nullable
    Boolean has_financing_options;
    @Nullable
    Boolean has_size_context;
    @Nullable
    Boolean skip_personalized;

    public SearchQueryArgs(String memberId, String channel, String category,
                           Boolean newSearch,
                           Integer offset) {
        member_id = memberId;
        this.channel = channel;
        this.category = category;
        new_search = newSearch;
        this.offset = offset;
    }
}
