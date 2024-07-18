package com.graqr.threshr;

import java.security.SecureRandom;
import java.util.Base64;

class Utils {
    /**
     * Generates a secure random string of the specified length.
     *
     * @param  length  the length of the random string to generate
     * @return         the generated random string
     */
    public static String getSecureRandomString(int length) {
        SecureRandom random = new SecureRandom(); // Compliant for security-sensitive use cases
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(bytes);
    }
}
