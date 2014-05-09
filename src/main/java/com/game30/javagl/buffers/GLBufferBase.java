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

    /** The buffer bind target. */
    private final GLBufferTarget target;

    /** The buffer usage pattern. */
    private final GLBufferUsage usage;

    /**
     * Constructs a GLBufferBase instance with the specified bind target and usage pattern.
     *
     * @param target the buffer bind target.
     * @param usage the buffer usage pattern.
     */
    protected GLBufferBase(GLBufferTarget target, GLBufferUsage usage) {
        super(GL15.glGenBuffers());
        this.target = target;
        this.usage = usage;
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
