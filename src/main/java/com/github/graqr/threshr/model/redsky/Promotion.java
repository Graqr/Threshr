package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Promotion(
        @JsonProperty("plp_message")
        String plpMessage,

        @JsonProperty("promotion_id")
        String promotionId,

        @JsonProperty("promotion_class")
        String promotionClass,

        @JsonProperty("subscription_type")
        String subscriptionType,

        @JsonProperty("threshold_type")
        String thresholdType,

        @JsonProperty("threshold_value")
        Double thresholdValue,

        @JsonProperty("reward_type")
        String rewardType,

        @JsonProperty("circle_offer")
        Boolean circleOffer,

        @JsonProperty("reward_value")
        Double rewardValue
) {
}
