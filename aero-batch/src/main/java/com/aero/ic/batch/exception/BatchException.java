package com.aero.ic.batch.exception;

/**
 * Created by nairr5 on 7/25/16.
 */
public class BatchException extends Exception {

    public BatchException() {
        super();
    }

    public BatchException(String message) {
        super(message);
    }

    public BatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
