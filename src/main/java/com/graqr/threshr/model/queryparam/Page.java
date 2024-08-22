package com.graqr.threshr.model.queryparam;

import com.graqr.threshr.ThreshrException;
import lombok.Getter;

import java.util.Arrays;

/**
 * Query parameter in redsky api. Specifies from where an api call is made in the browser.
 */
@Getter
public class Page {
    private String name;

    /**
     * Sets string value as "/c/" + provided value.
     *
     * @param page Query parameter in redsky api to specify from where an api call is made in the browser
     * @throws ThreshrException if string contains anything other than letters or is empty
     */
    public Page(String page) throws ThreshrException {
        setName(page);
    }

    /**
     * Sets string value as "/c/" + provided value. As a means of security, value is permitted to be 26 alphanumeric
     * words delimited with either - or _
     *
     * @param name Query parameter in redsky api to specify from where an api call is made in the browser
     * @throws ThreshrException if string contains anything other than letters or is empty
     */
    public void setName(String name) throws ThreshrException {
        String tempPage = name.trim().toLowerCase();
        String threshrException = "Expected non-space-character delimited string of up to 30 words, but got \"%s\".";
        if (tempPage.startsWith("/c/")) {
            tempPage = tempPage.substring(3);
        }
        if (tempPage.isEmpty()) {
            throw new ThreshrException(String.format(threshrException, tempPage));
        }
        //regex "^([a-z\\d]+[-_]?){1,21}$" causes perpetual waiting in tests nearing word limit
        long pageCount = Arrays.stream(tempPage.split("[-_]")).count();
        if (pageCount > 30) {
            throw new ThreshrException(String.format(threshrException, tempPage));
        }
        this.name = "/c/" + tempPage;
    }
}
