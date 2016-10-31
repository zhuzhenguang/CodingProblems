package com.thoughtworks.train;

/**
 * No Such Route
 * <p>
 * Created by napoleon on 01/11/2016.
 */
class NoSuchRouteException extends RuntimeException {
    NoSuchRouteException(String message) {
        super(message);
    }
}
