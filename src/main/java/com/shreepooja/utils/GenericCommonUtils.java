package com.shreepooja.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * This class shall have common utility methods used across device service
 */
@Slf4j
public class GenericCommonUtils {
    /**
     * Builds the API Response given the object data to be displayed,
     * If in case of exception, the Exception object details are used to embed that info.
     *
     * @param obj        the object to be displayed.
     * @param message    the message to dislayed
     * @param statusCode the status code.
     * @return returns the APIResponse object for the given details.
     */
    public static ApiResponse buildResponse(final Object obj, final String message, final boolean success,
                                            final int statusCode, final Exception ex) {
        log.debug("Constructing API Response for: {}", ex);

        final ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(statusCode);
        apiResponse.setSuccess(success);
        apiResponse.setData(obj);
        apiResponse.setMessage(message);
        if (ex != null) {
            // Error Message details, right now displaying root cause message only.
            // We can add more details if required.
            ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage(),
                    ExceptionUtils.getRootCauseMessage(ex));
            // Overwrite with the exception message.
            // TODO: We can rework on it.
            apiResponse.setMessage(ex.getMessage());
            apiResponse.setErrorResponse(errorResponse);
        }

        return apiResponse;
    }
}
