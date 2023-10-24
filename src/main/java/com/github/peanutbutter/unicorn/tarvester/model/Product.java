package com.github.peanutbutter.unicorn.tarvester.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Product {

    @lombok.Data
    private static class Any {
        int tcins;
    }

    @lombok.Data
    private static class BundleComponents {
        @JsonProperty("productRelationshipType")
        private String productRelationshipType;
    }

    @lombok.Data
    private static class ProductSummaries {
        @JsonProperty("productSummaries")
        private List<ProductSummary> productSummaries;
    }

    @lombok.Data
    private static class EligibilityRules {
        private Grocery grocery;
    }

    @lombok.Data
    private static class Enrichment {
        @JsonProperty("buyUrl")
        private String buyUrl;

        public Enrichment(String buyUrl) {
            this.buyUrl = buyUrl;
        }
    }

    @lombok.Data
    private static class Fulfillment {
        @JsonProperty("productId")
        private String productId;
        @JsonProperty("isOutOfStockInAllStoreLocations")
        private Boolean isOutOfStockInAllStoreLocations;
        @JsonProperty("shippingOptions")
        private ShippingOptions shippingOptions;
        @JsonProperty("storeOptions")
        private List<StoreOption> storeOptions;
        @JsonProperty("scheduledDelivery")
        private ScheduledDelivery scheduledDelivery;
    }

    @lombok.Data
    private static class Grocery {
        @JsonProperty("isActive")
        private Boolean isActive;
    }

    @lombok.Data
    private static class InStoreOnly {
        @JsonProperty("availabilityStatus")
        private String availabilityStatus;
    }

    @lombok.Data
    private static class Item {
        @JsonProperty("isLimitedTimeOffer")
        private Boolean isLimitedTimeOffer;
        @JsonProperty("relationshipTypeCode")
        private String relationshipTypeCode;
        @JsonProperty("productDescription")
        private ProductDescription productDescription;
        private Enrichment enrichment;
        private Map<String, Any> fulfillment;
        @JsonProperty("merchandiseClassification")
        private MerchandiseClassification merchandiseClassification;
        @JsonProperty("productVendors")
        private List<ProductVendor> productVendors;
        @JsonProperty("eligibilityRules")
        private EligibilityRules eligibilityRules;
        @JsonProperty("bundleComponents")
        private BundleComponents bundleComponents;
    }

    @lombok.Data
    private static class MerchandiseClassification {
        @JsonProperty("classId")
        private Long classId;
        @JsonProperty("departmentId")
        private Long departmentId;
    }

    @lombok.Data
    private static class OrderPickup {
        @JsonProperty("availabilityStatus")
        private String availabilityStatus;
        @JsonProperty("pickupDate")
        private String pickupDate;
        @JsonProperty("guestPickSla")
        private Long guestPickSla;
        @JsonProperty("locationLocale")
        private String locationLocale;
    }

    @lombok.Data
    private static class ProductDescription {
        private String title;
    }

    @lombok.Data
    private static class ProductSummary {
        @JsonProperty("Typename")
        private String typename;
        private String tcin;
        private Item item;
        private Fulfillment fulfillment;
    }

    @lombok.Data
    private static class ProductVendor {
        private String id;
    }

    @lombok.Data
    private static class ScheduledDelivery {
        @JsonProperty("availabilityStatus")
        private String availabilityStatus;
        @JsonProperty("locationAvailableToPromiseQuantity")
        private Double locationAvailableToPromiseQuantity;
    }

    @lombok.Data
    private static class ShippingOptions {
        @JsonProperty("availabilityStatus")
        private String availabilityStatus;
        @JsonProperty("loyaltyAvailabilityStatus")
        private String loyaltyAvailabilityStatus;
        private List<?> services;
    }

    @lombok.Data
    private static class ShipToStore {
        @JsonProperty("availabilityStatus")
        private String availabilityStatus;
    }

    @lombok.Data
    private static class Store {
        @JsonProperty("locationName")
        private String locationName;
        private int[] latAndLong;
    }

    @lombok.Data
    private static class StoreOption {
        @JsonProperty("searchResponseStoreType")
        private String searchResponseStoreType;
        @JsonProperty("locationAvailableToPromiseQuantity")
        private Double locationAvailableToPromiseQuantity;
        @JsonProperty("locationId")
        private String locationId;
        private Store store;
        @JsonProperty("orderPickup")
        private OrderPickup orderPickup;
        @JsonProperty("inStoreOnly")
        private InStoreOnly inStoreOnly;
        @JsonProperty("shipToStore")
        private ShipToStore shipToStore;
    }
}
