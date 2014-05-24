package com.game30.javagl.buffers;

import org.lwjgl.opengl.GL15;

import com.game30.javagl.GLObjectBase;

/**
 * Base class for {@link GLBuffer}s.  This provides basic target and usage behavior.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public class GLBufferBase extends GLObjectBase implements GLBuffer {

    /** The buffer primitive type. */
    private final GLBufferType type;

    /** The buffer bind target. */
    private final GLBufferTarget target;

    /** The buffer usage pattern. */
    private final GLBufferUsage usage;

    /**
     * Constructs a GLBufferBase instance with the specified primitive type, bind target and usage pattern.
     *
     * @param type the buffer primitive type.
     * @param target the buffer bind target.
     * @param usage the buffer usage pattern.
     */
    protected GLBufferBase(GLBufferType type, GLBufferTarget target, GLBufferUsage usage) {
        super(GL15.glGenBuffers());
        this.type = type;
        this.target = target;
        this.usage = usage;
    }

    @Override
    public void delete() {
        GLBuffer.super.delete();
        super.delete();
    }

    @Override
    public GLBufferType getType() {
        return type;
    }

    @Override
    public GLBufferTarget getTarget() {
        return target;
    }

    @Override
    public GLBufferUsage getUsage() {
        return usage;
    }
}
