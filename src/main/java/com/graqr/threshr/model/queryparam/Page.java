package com.graqr.threshr.model.queryparam;

import com.graqr.threshr.ThreshrException;
import lombok.Getter;

/**
 * Query parameter in redsky api. Specifies from where an api call is made in the browser.
 */
@Getter
public class Page {
    private String page;

    /**
     * Sets string value as "/c/" + provided value.
     *
     * @param page Query parameter in redsky api to specify from where an api call is made in the browser
     * @throws ThreshrException if string contains anything other than letters or is empty
     */
    public Page(String page) throws ThreshrException {
        setPage(page);
    }

    /**
     * Sets string value as "/c/" + provided value.
     *
     * @param page Query parameter in redsky api to specify from where an api call is made in the browser
     * @throws ThreshrException if string contains anything other than letters or is empty
     */
    public void setPage(String page) throws ThreshrException {
        String tempPage = page.trim().toLowerCase();
        if (tempPage.startsWith("/c/")) {
            tempPage = tempPage.substring(3);
        }
        if (tempPage.matches(".+([^(a-z|\\-)]).+") || tempPage.isEmpty()) {
            throw new ThreshrException(String.format(
                    "Expected only letters for the page value, but received \"%s\".", tempPage));
        }
        this.page = "/c/" + tempPage;
    }
}
