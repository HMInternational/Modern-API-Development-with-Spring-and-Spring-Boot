package com.packt.modern.api.exceptions;

import org.apache.logging.log4j.util.Strings;

/**
 * Error
 * <p>
 * Complex type that contains error details for a REST API calls.
 *
 * @author : github.com/sharmasourabh
 * @project : Chapter03 - Modern API Development with Spring and Spring Boot
 * @created : 11/04/2020, Tuesday
 **/
public class Error {

    private static final long serialVersionUID = 1L;
    /**
     * Application error code, which is different from HTTP error code.
     */
    private String errorCode;

    /**
     * Short, human-readable summary of the problem.
     */
    private String message;

    /**
     * HTTP status code for this occurrence of the problem, set by the origin server.
     */
    private Integer status;

    /**
     * Url of request that produced the error.
     */
    private String url = "Not available";

    /**
     * Method of request that produced the error.
     */
    private String reqMethod = "Not available";

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public Error setUrl(final String url) {
        if (Strings.isNotBlank(url)) {
            this.url = url;
        }
        return this;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public Error setReqMethod(final String method) {
        if (Strings.isNotBlank(method)) {
            reqMethod = method;
        }
        return this;
    }
}
