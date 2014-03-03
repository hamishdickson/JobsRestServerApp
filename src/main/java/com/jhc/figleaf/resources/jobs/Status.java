package com.jhc.figleaf.resources.jobs;

/**
 * User: DicksonH
 * Date: 03/03/14
 * Time: 13:44
 *
 * Valid job statuses'
 */
public enum Status {
    NOT_STARTED("A"),
    STARTED("B"),
    CLOSED("C"),
    ON_HOLD("H"),
    ON_WAIT("W");

    private String statusCode;

    private Status(String s) {
        statusCode = s;
    }

    private String getStatusCode() {
        return statusCode;
    }

}
