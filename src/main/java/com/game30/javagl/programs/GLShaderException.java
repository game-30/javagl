package com.game30.javagl.programs;

import com.game30.javagl.GLException;

/**
 * A {@link GLException} specific to {@link GLShader}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLShaderException extends GLException {

    private static final long serialVersionUID = 2824577593360025944L;

    /**
     * Constructs a new OpenGL exception.
     */
    public GLShaderException() {
    }

    /**
     * Constructs a new exception with the specified message.
     *
     * @param message the exception message.
     */
    public GLShaderException(String message) {
        super(message);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause with the specified message.
     *
     * @param message the exception message.
     * @param cause the exception cause.
     */
    public GLShaderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause.
     *
     * @param cause the exception cause.
     */
    public GLShaderException(Throwable cause) {
        super(cause);
    }
}
