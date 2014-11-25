package com.game30.javagl.arrays;

/**
 * The base factory implementation for {@link GLVertexArray}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLVertexArrayFactoryBase implements GLVertexArrayFactory {

    @Override
    public GLVertexArray create() {
        return new GLVertexArrayBase();
    }
}
