package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Product(
    @param:JsonProperty("__typename") val typename: String,
    val tcin: String,
    @param:Nullable @param:JsonProperty("original_tcin") val originalTcin: String,
    val category: Category,
    @param:JsonProperty("ratings_and_reviews") val ratingsAndReviews: RatingsAndReviews,
    val item: Item,
    @param:JsonProperty("finds_stories") val findStories: List<FindsStory>,
    @param:Nullable @param:JsonProperty("finds_posts") val findsPosts: List<FindsPost>,
    val price: Price,
    val promotions: List<Any>
) {

}