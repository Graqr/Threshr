package com.graqr.threshr.circleStore.model.queryparam

/**
 * This class represents a location in the USA. It is used by the RedSky API's Nearby Stores endpoint, which
 * accepts a location in the form of a zipcode or a city, state combo. The Nearby Stores endpoint will return a
 * list of stores near the given location.
 *
 * @param zipOrCity either a zipcode or a city and state provided as two separate strings
 * @author Jonathan Zollinger
 * @since 0.1.0
 */
class Place(val zipOrCity: String) {
    /*
     * Initializes a Place object using a zipcode.
     *
     * This constructor is used when the location is provided as a zipcode.
     * The zipcode must be a 5-digit number and can optionally include a 4-digit extension,
     * separated by a hyphen or space.
     */
    init {
        require(zipOrCity matches Regex("^\\d{5}[-|\\s]?(\\d{4})?$")) {
            "Invalid zipcode provided. Zipcode must be a 5-digit number optionally followed by a 4-digit extension."
        }
    }


    /**
     * Initializes a Place object using a city and state.
     *
     * @param city city name
     * @param state state name
     */
    constructor(city: String, state: String) : this("$city, $state") {
        //match weird strings like D'Amoreport (texas) and Coeur D'Alene (idaho)
        val pattern = Regex("^([a-zA-Z|\\u0080-\\u024F]\\W?)*+$")
        require(city matches pattern) {
            "Invalid city string provided, \"$city\". City must contain only letters and whitespace."
        }
        require(state matches pattern) {
            "Invalid state string provided, \"$state\". State must contain only letters and whitespace."
        }
    }
}
