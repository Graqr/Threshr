package com.graqr.threshr.model.queryparam;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Serdeable
@Data
public class Place {
    private final String place;

    public Place(String zipcode) {
        if (!String.valueOf(zipcode).matches("^\\d{5}(-|\\s*)?(\\d{4})?$")) {
            throw new IllegalArgumentException("Invalid zipcode provided, \"" + zipcode + "\". Zipcode provided " +
                    "must match this regex: \"^\\d{5}(-|\\s*)?(\\d{4})?$\"");
        }
        place = zipcode;

    }

    public Place(String city, String state) {
        String errorMessage = "";
        if (!String.valueOf(city).matches("^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*$")) {
            errorMessage = "Invalid city string provided, \"" + city + "\". String provided " +
                    "must match this regex: \"^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*$\".";
        } else if (city.isEmpty()) {
            errorMessage = "String value for city cannot be empty.";
        }
        if (!String.valueOf(state).matches("^[A-Z][a-z]+(?: +[A-Z][a-z]+)*$")) {
            errorMessage = "Invalid state string provided, \"" + state + "\". String provided " +
                    "must match this regex: \"^[A-Z][a-z]+(?: +[A-Z][a-z]+)*$\".";
        } else if (state.isEmpty()) {
            errorMessage += "String value for state cannot be empty.";
        }
        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        place = String.format("%s, %s", city, state);
    }
}
