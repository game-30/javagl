package com.game30.javagl.buffers;

import org.lwjgl.opengl.GL15;

import com.game30.javagl.GLMagicInteger;
import com.game30.javagl.GLMagicIntegerException;
import com.game30.javagl.GLMagicInteger;
import com.game30.javagl.GLMagicIntegerException;

/**
 * An enumeration of the different usages of a OpenGL buffer.  These enumerations are the different combinations of
 * access and frequency.  Each enumeration also represents a specific OpenGL magic integer that can be accessed using
 * the GLMagicInteger interface.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public enum GLBufferUsage implements GLMagicInteger {

    /**
     * A combination of write access and static frequency.
     */
    WriteStatic(GLBufferUsageAccess.Write, GLBufferUsageFrequency.Static, GL15.GL_STATIC_DRAW),

    /**
     * A combination of write access and dynamic frequency.
     */
    WriteDynamic(GLBufferUsageAccess.Write, GLBufferUsageFrequency.Dynamic, GL15.GL_DYNAMIC_DRAW),

    /**
     * A combination of write access and stream frequency.
     */
    WriteStream(GLBufferUsageAccess.Write, GLBufferUsageFrequency.Stream, GL15.GL_STREAM_DRAW),

    /**
     * A combination of read access and static frequency.
     */
    ReadStatic(GLBufferUsageAccess.Read, GLBufferUsageFrequency.Static, GL15.GL_STATIC_READ),

    /**
     * A combination of read access and dynamic frequency.
     */
    ReadDynamic(GLBufferUsageAccess.Read, GLBufferUsageFrequency.Dynamic, GL15.GL_DYNAMIC_READ),

    /**
     * A combination of read access and stream frequency.
     */
    ReadStream(GLBufferUsageAccess.Read, GLBufferUsageFrequency.Stream, GL15.GL_STREAM_READ),

    /**
     * A combination of none access and static frequency.
     */
    NoneStatic(GLBufferUsageAccess.None, GLBufferUsageFrequency.Static, GL15.GL_STATIC_COPY),

    /**
     * A combination of none access and dynamic frequency.
     */
    NoneDynamic(GLBufferUsageAccess.None, GLBufferUsageFrequency.Dynamic, GL15.GL_DYNAMIC_COPY),

    /**
     * A combination of none access and stream frequency.
     */
    NoneStream(GLBufferUsageAccess.None, GLBufferUsageFrequency.Stream, GL15.GL_STREAM_COPY),

    // End of enumeration
    ;

    /**
     * Returns the GLBufferUsage that corresponds to the specified OpenGL magic integer.
     *
     * @param glInt the usage magic integer.
     * @return the corresponding GLBufferUsage.
     * @throws GLMagicIntegerException if the specified magic integer does not match a
     * enumeration instance.
     */
    public static GLBufferUsage fromGLInt(int glInt) throws GLMagicIntegerException {
        // While it may not be the most elegant, switch is definitely the fastest.
        switch (glInt) {
            case GL15.GL_STATIC_DRAW:
                return GLBufferUsage.WriteStatic;
            case GL15.GL_DYNAMIC_DRAW:
                return GLBufferUsage.WriteDynamic;
            case GL15.GL_STREAM_DRAW:
                return GLBufferUsage.WriteStream;
            case GL15.GL_STATIC_READ:
                return GLBufferUsage.ReadStatic;
            case GL15.GL_DYNAMIC_READ:
                return GLBufferUsage.ReadDynamic;
            case GL15.GL_STREAM_READ:
                return GLBufferUsage.ReadStream;
            case GL15.GL_STATIC_COPY:
                return GLBufferUsage.NoneStatic;
            case GL15.GL_DYNAMIC_COPY:
                return GLBufferUsage.NoneDynamic;
            case GL15.GL_STREAM_COPY:
                return GLBufferUsage.NoneStream;
            default:
                throw new GLMagicIntegerException("Could not match to a GLBufferUsage.");
        }
    }

    /** The buffer access of the usage. */
    private final GLBufferUsageAccess access;

    /** The buffer frequency of the usage. */
    private final GLBufferUsageFrequency frequency;

    /** The OpenGL magic integer of the usage. */
    private final int glInt;

    /**
     * Creates a new buffer usage with the specified access, frequency, and magic integer.
     *
     * @param access the buffer access.
     * @param frequency the buffer frequency.
     * @param glInt the usage magic integer.
     */
    GLBufferUsage(GLBufferUsageAccess access, GLBufferUsageFrequency frequency, int glInt) {
        this.access = access;
        this.frequency = frequency;
        this.glInt = glInt;
    }

    /**
     * Returns the buffer usage access.
     *
     * @return the buffer usage access.
     */
    public GLBufferUsageAccess getAccess() {
        return access;
    }

    /**
     * Returns the buffer usage frequency.
     *
     * @return the buffer usage frequency.
     */
    public GLBufferUsageFrequency getFrequency() {
        return frequency;
    }

    @Override
    public int glInt() {
        return glInt;
    }
}
