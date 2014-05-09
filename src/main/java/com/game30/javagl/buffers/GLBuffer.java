package com.game30.javagl.buffers;

import org.lwjgl.opengl.GL15;

import com.game30.javagl.GLDeletable;
import com.game30.javagl.GLIndexed;
import com.game30.javagl.GLObject;

/**
 * An GLBuffer represents an OpenGL buffer.  This is how data is passed back and forth to OpenGL from memory.  All
 * rendering data needs to be contained within a buffer before OpenGL can render it.  Any calculations OpenGL does for
 * the program will be output into a buffer.  So to render graphics, or to get the results of a calculation, an OpenGL
 * buffer needs to exist.
 *
 * <p />This interface provides some simple usage of an OpenGL buffer.  Since a buffer is an OpenGL object, it can be
 * bound and unbound from the current context.  Each buffer has a specific target that it is bound to.  Only one buffer
 * can be bound to a specific usage at a time.  A buffer must be bound for data to be read or written to it.
 *
 * <p />OpenGL buffers also have an expected usage pattern.  This describes to OpenGL how the buffer will be used.
 * Buffers can be read-only, write-only, or have no access by the processor.  The buffer can be considered static,
 * dynamic or stream which describes how often the buffer might be accessed.  See {@link GLBufferUsageAccess} for
 * details on buffer access and {@link GLBufferUsageFrequency} for details on buffer access frequency.  These two
 * different details combine into the usage pattern of the buffer which is detailed by {@link GLBufferUsage}.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public interface GLBuffer extends GLObject {

    @Override
    default boolean exists() {
        return GL15.glIsBuffer(getIndex());
    }

    @Override
    default void delete() {
        GL15.glDeleteBuffers(getIndex());
    }

    @Override
    default void bind() {
        GLDeletable.requireExists(this);
        GL15.glBindBuffer(getTarget().glInt(), getIndex());
    }

    @Override
    default void unbind() {
        GLDeletable.requireExists(this);
        GL15.glBindBuffer(getTarget().glInt(), GLIndexed.NULL_INDEX);
    }

    /**
     * Returns the target to which the buffer object is bound.
     *
     * @return buffer bind target.
     */
    GLBufferTarget getTarget();

    /**
     * Returns the expected usage pattern of the buffer.
     *
     * @return buffer usage.
     */
    GLBufferUsage getUsage();
}
