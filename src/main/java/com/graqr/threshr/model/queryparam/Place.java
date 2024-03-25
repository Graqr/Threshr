package com.graqr.threshr.model.queryparam;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

/**
 * Place is a query parameter used when querying nearby target store locations. The query accepts either a zipcode
 * or a city-state combo. See {@link com.graqr.threshr.Threshr#queryStoreLocations(Place)}.
 */
@Serdeable
@Data
public class Place {
    private final String zipOrCityState;
    public Place(String zipcode) {
        if (!String.valueOf(zipcode).matches("^\\d{5}[-|\\s]?(\\d{4})?$")) {
            throw new IllegalArgumentException("Invalid zipcode provided, \"" + zipcode + "\". Zipcode provided " +
                    "must match this regex: \"^\\d{5}(-|\\s*)?(\\d{4})?$\"");
        }
        zipOrCityState = zipcode;
    }

    public Place(String city, String state) {
        String errorMessage = "";
        //match weird strings like D'Amoreport (texas) and Coeur D'Alene (idaho)
        String pattern = "^([a-zA-Z|\\u0080-\\u024F]\\W?)*+$"; // *+ quantifier prevents backtracking
        if (!String.valueOf(city).matches(pattern)) {
            errorMessage = "Invalid city string provided, \"" + city + "\".";
        } else if (city.isEmpty()) {
            errorMessage = "String value for city cannot be empty.";
        }
        if (!String.valueOf(state).matches(pattern)) {
            errorMessage = "Invalid state string provided, \"" + state + "\".";
        } else if (state.isEmpty()) {
            errorMessage += "String value for state cannot be empty.";
        }
        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        zipOrCityState = String.format("%s, %s", city, state);
    }
}
