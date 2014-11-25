package com.game30.javagl.arrays;

/**
 * A factory interface for {@link GLVertexArray}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLVertexArrayFactory {

    /**
     * Creates a new OpenGL program.
     *
     * @return a new OpenGL program.
     */
    GLVertexArray create();
}
