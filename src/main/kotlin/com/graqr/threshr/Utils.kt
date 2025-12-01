package com.graqr.threshr

import io.micronaut.http.HttpResponse
import java.security.SecureRandom
import java.util.Base64

internal object Utils {
    /**
     * Generates a secure random string of the specified length.
     *
     * @param  length  the length of the random string to generate
     * @return         the generated random string
     */
    fun getSecureRandomString(length: Int): String {
        val random: SecureRandom = SecureRandom() // Compliant for security-sensitive use cases
        val bytes = ByteArray(length)
        random.nextBytes(bytes)
        val encoder: Base64.Encoder = Base64.getUrlEncoder().withoutPadding()
        return encoder.encodeToString(bytes)
    }

    /**
     * Checks if the provided HttpResponse object has a null body and throws a ThreshrException if it does.
     *
     * @param <T> The type of object expected in the response body.
     * @return The body of the HttpResponse object if it's not null.
     * @throws ThreshrException If the response body is null.
     */
    @Throws(ThreshrException::class)
    fun <T> nullCheck(response: HttpResponse<T> ): T {
        return response.body() ?: throw ThreshrException(
            "Response body is null or of an unexpected type.\n" +
                    "Response Code: ${response.code()}\nStatus: ${response.status}"
        )
    }
}