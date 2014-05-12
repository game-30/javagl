package com.game30.javagl.buffers;

import com.game30.javagl.GLException;

/**
 * A {@link GLException} specific to {@link GLBuffer}s.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public class GLBufferException extends GLException {

    /**
     * Constructs a new OpenGL exception.
     */
    public GLBufferException() {
    }

    /**
     * Constructs a new exception with the specified message.
     *
     * @param message the exception message.
     */
    public GLBufferException(String message) {
        super(message);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause with the specified message.
     *
     * @param message the exception message.
     * @param cause the exception cause.
     */
    public GLBufferException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause.
     *
     * @param cause the exception cause.
     */
    public GLBufferException(Throwable cause) {
        super(cause);
    }
}
