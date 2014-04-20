package com.game30.graphics.javagl;

/**
 * Describes an object in OpenGL that can be bound and unbound to the current context.
 *
 * @author Brian Norman
 * @since 1.0
 */
public interface GLBindable {

    /**
     * Binds the OpenGL object to the current context.  Object bound to the current context will be manipulated by
     * changing the state of the current context.
     */
    void bind();

    /**
     * Unbinds the OpenGL object from the current context.  Usually this means binding the zero object to the current
     * context.
     */
    void unbind();
}
