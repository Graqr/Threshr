package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductVendor(val id: String, @param:JsonProperty("vendor_name") val vendorName: String) {}
