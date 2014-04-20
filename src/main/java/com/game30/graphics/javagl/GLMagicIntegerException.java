package com.game30.graphics.javagl;

/**
 * A {@link com.game30.graphics.javagl.GLException} specific to {@link com.game30.graphics.javagl.GLMagicInteger}s.
 *
 * @author Brian Norman
 * @since 1.0
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
