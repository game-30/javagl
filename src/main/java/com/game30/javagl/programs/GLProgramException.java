package com.game30.javagl.programs;

import com.game30.javagl.GLException;

/**
 * A {@link GLException} specific to {@link GLProgram}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLProgramException extends GLException {

    /**
     * Constructs a new OpenGL exception.
     */
    public GLProgramException() {
    }

    /**
     * Constructs a new exception with the specified message.
     *
     * @param message the exception message.
     */
    public GLProgramException(String message) {
        super(message);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause with the specified message.
     *
     * @param message the exception message.
     * @param cause the exception cause.
     */
    public GLProgramException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new OpenGL exception that wraps the specified cause.
     *
     * @param cause the exception cause.
     */
    public GLProgramException(Throwable cause) {
        super(cause);
    }
}
