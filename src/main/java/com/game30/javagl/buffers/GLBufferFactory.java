package com.game30.javagl.buffers;

/**
 * A factory interface for {@link GLBuffer}s.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public interface GLBufferFactory {

    /**
     * Returns the default OpenGL buffer factory.
     *
     * @return default buffer factory.
     */
    static GLBufferFactory getDefault() {
        return GLBufferBase::new;
    }


    /**
     * Creates a new OpenGL buffer from the specified parameters.
     *
     * @param type the buffer primitive type.
     * @param target the bind target for the buffer.
     * @param usage the usage pattern for the buffer.
     * @return a new OpenGL buffer.
     */
    GLBuffer create(GLBufferType type, GLBufferTarget target, GLBufferUsage usage);
}
