package com.game30.javagl.buffers;

import java.nio.Buffer;

import org.lwjgl.opengl.EXTDirectStateAccess;
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
 * bound and unbound from the current context.  Each buffer has a specific {@link GLBufferTarget} that it is bound to.
 * Only one buffer can be bound to a specific usage at a time.  A buffer must be bound for data to be read or written to
 * it.
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
     * Returns the primitive type which the buffer object stores.
     *
     * @return buffer primitive type.
     */
    GLBufferType getType();

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

    /**
     * Reads data from the OpenGL buffer and returns it as a {@link Buffer}.
     *
     * @return data from buffer.
     */
    default Buffer read() {
        if (GLBufferUsageAccess.Read != getUsage().getAccess()) {
            throw new GLBufferException("Cannot read data to a [" + getUsage() + "] buffer.");
        }
        int size = getType().fromByteSize(
                EXTDirectStateAccess.glGetNamedBufferParameterEXT(getIndex(), GL15.GL_BUFFER_SIZE));
        return getType().readFromBuffer(this, 0, size);
    }

    /**
     * Reads data from the OpenGL buffer at the specific offset for the specific length and returns it as a {@link
     * Buffer}.
     *
     * @param offset the offset to start the read.
     * @param length the length of the read.
     * @return data from buffer range.
     */
    default Buffer read(int offset, int length) {
        if (GLBufferUsageAccess.Read != getUsage().getAccess()) {
            throw new GLBufferException("Cannot read data to a [" + getUsage() + "] buffer.");
        }
        return getType().readFromBuffer(this, offset, length);
    }

    /**
     * Writes data to the OpenGL buffer.
     *
     * @param data data to write.
     */
    default void write(Buffer data) {
        if (GLBufferUsageAccess.Write != getUsage().getAccess()) {
            throw new GLBufferException("Cannot write data to a [" + getUsage() + "] buffer.");
        }
        getType().writeToBuffer(this, data, getUsage());
    }
}
