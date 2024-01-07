package com.github.graqr.threshr.model.silo;

public class Weight {

    private enum unit{
        OZ("ounce", "oz", 28.3495);
        final String type;
        final String abbreviation;
        final double conversionFactor;

        unit(String type, String abbreviation, double conversionFactor) {
            this.type = type;
            this.abbreviation = abbreviation;
            this.conversionFactor = conversionFactor;
        }
    }
}
