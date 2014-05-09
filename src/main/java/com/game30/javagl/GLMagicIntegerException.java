package com.game30.javagl;

/**
 * A {@link GLException} specific to {@link GLMagicInteger}s.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public class GLMagicIntegerException extends GLException {

    /**
     * Constructs a new OpenGL exception.
     */
    public GLMagicIntegerException() {
    }

    /**
     * Constructs a new exception with the specified message.
     *
     * @param message the exception message.
     */
    public GLMagicIntegerException(String message) {
        super(message);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause with the specified message.
     *
     * @param message the exception message.
     * @param cause the exception cause.
     */
    public GLMagicIntegerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause.
     *
     * @param cause the exception cause.
     */
    public GLMagicIntegerException(Throwable cause) {
        super(cause);
    }
}
