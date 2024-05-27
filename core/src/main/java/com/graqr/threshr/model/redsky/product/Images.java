package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
public record Images(
        @JsonProperty("primary_image_url")
        URL primaryImageUrl,
        @JsonProperty("alternate_image_urls")
        URL[] alternateImageUrls,
        @Nullable @JsonProperty("base_url")
        String baseUrl,
        @Nullable @JsonProperty("primary_image")
        String primaryImage,
        @Nullable @JsonProperty("alternate_images")
        List<String> alternateImages,
        @Nullable @JsonProperty("content_labels")
        List<ContentLabel> contentLabels
) {
    @Override
    public boolean equals(Object  object) {
        if (this ==  object) return true;
        if ( object == null || getClass() !=  object.getClass()) return false;
        Images images = (Images)  object;
        return Objects.equals(primaryImageUrl, images.primaryImageUrl) &&
                Arrays.equals(alternateImageUrls, images.alternateImageUrls) &&
                Objects.equals(baseUrl, images.baseUrl) &&
                Objects.equals(primaryImage, images.primaryImage) &&
                Objects.equals(alternateImages, images.alternateImages) &&
                Objects.equals(contentLabels, images.contentLabels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(primaryImageUrl, baseUrl, primaryImage, alternateImages, contentLabels);
        result = 31 * result + Arrays.hashCode(alternateImageUrls);
        return result;
    }
}
