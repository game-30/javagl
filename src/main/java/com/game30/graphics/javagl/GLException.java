package com.game30.graphics.javagl;

/**
 * The base class for all runtime OpenGL exceptions.
 *
 * @author Brian Norman
 * @since 1.0
 */
public abstract class GLException extends RuntimeException {

    /**
     * Constructs a new OpenGL exception.
     */
    public GLException() {
    }

    /**
     * Constructs a new OpenGL exception with the specified message.
     *
     * @param message the exception message.
     */
    public GLException(String message) {
        super(message);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause with the specified message.
     *
     * @param message the exception message.
     * @param cause the exception cause.
     */
    public GLException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause.
     *
     * @param cause the exception cause.
     */
    public GLException(Throwable cause) {
        super(cause);
    }
}
