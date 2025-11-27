package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable
import java.net.URL
import java.util.*


/**
 * @param primaryImageUrl full url path for the main image url. ie
 * {@code 'https://target.scene7.com/is/image/Target/GUEST_5f9b4f10-995c-4cc4-8c31-98a5417fb5cb'}
 * @param alternateImageUrls an Array of full url paths, each url like {@link Images#primaryImageUrl}'s example.
 * @param baseUrl the url from the domain (inclusive) to the path (non-inclusive), ie {@code '//target.scene7.com/is/image/Target/'}.
 * @param primaryImage path of the primary image url. ie the {@code 'GUEST_5f9b4f10-995c-4cc4-8c31-98a5417fb5cb'} part
 *                     of {@link Images#primaryImageUrl}'s example.
 * @param alternateImages the paths of the alternateImageUrls. See {@link Images#primaryImage}
 * @param contentLabels I got no clue on this. these images are different URLs than the other images, but they're
 *                      the same images, down to the size and format. Index 0 corresponds to the main image, then the
 *                      alternate images are in order from index 1 - 4.
 *
 * @author Jonathan Zollinger
 * @since 0.0.11
 */
@Serdeable
data class Images(
    @param:JsonProperty("primary_image_url") val primaryImageUrl: URL,
    @param:JsonProperty("alternate_image_urls") val alternateImageUrls: Array<URL>,
    @param:Nullable @param:JsonProperty("base_url") val baseUrl: String,
    @param:Nullable @param:JsonProperty("primary_image") val primaryImage: String,
    @param:Nullable @param:JsonProperty("alternate_images") val alternateImages: List<String>,
    @param:Nullable @param:JsonProperty("content_labels") val contentLabels: List<ContentLabel>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Images
        if (primaryImageUrl != other.primaryImageUrl) return false
        if (!alternateImageUrls.contentEquals(other.alternateImageUrls)) return false
        if (baseUrl != other.baseUrl) return false
        if (primaryImage != other.primaryImage) return false
        if (alternateImages != other.alternateImages) return false
        if (contentLabels != other.contentLabels) return false
        return true
    }

    override fun hashCode(): Int {
        val result = Objects.hash(
            primaryImageUrl, baseUrl, primaryImage, alternateImages, contentLabels
        ) * 31 + alternateImageUrls.contentHashCode()

        return result
    }
}
