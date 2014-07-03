package com.game30.javagl.buffers;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;

/**
 * An enumeration of the different primitive types which an OpenGL buffer can store.
 *
 * <p />This is sort of a hack class that gets around the restrictive nature of the LWJGL methods which only allow
 * specific types of {@link Buffer}s to be passed to the buffer write and read methods.  Each enumeration value contains
 * the behavior corresponding to the specific buffer type it represents.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public enum GLBufferType {

    /**
     * Byte primitive buffer type corresponding to the {@link ByteBuffer}.
     */
    Byte() {
        @Override
        int getByteShift() {
            return 0;
        }

        @Override
        ByteBuffer readFromBuffer(GLBufferTarget target, long offset, int length) {
            ByteBuffer data = BufferUtils.createByteBuffer(length);
            GL15.glGetBufferSubData(target.glInt(), offset, data);
            return data;
        }

        @Override
        void writeToBuffer(GLBufferTarget target, Buffer data, GLBufferUsage usage) {
            GL15.glBufferData(target.glInt(), (ByteBuffer) data, usage.glInt());
        }
    },

    /**
     * Short primitive buffer type corresponding to the {@link ShortBuffer}.
     */
    Short() {
        @Override
        int getByteShift() {
            return 1;
        }

        @Override
        ShortBuffer readFromBuffer(GLBufferTarget target, long offset, int length) {
            ShortBuffer data = BufferUtils.createShortBuffer(length);
            GL15.glGetBufferSubData(target.glInt(), offset, data);
            return data;
        }

        @Override
        void writeToBuffer(GLBufferTarget target, Buffer data, GLBufferUsage usage) {
            GL15.glBufferData(target.glInt(), (ShortBuffer) data, usage.glInt());
        }
    },

    /**
     * Integer primitive buffer type corresponding to the {@link IntBuffer}.
     */
    Integer() {
        @Override
        int getByteShift() {
            return 2;
        }

        @Override
        IntBuffer readFromBuffer(GLBufferTarget target, long offset, int length) {
            IntBuffer data = BufferUtils.createIntBuffer(length);
            GL15.glGetBufferSubData(target.glInt(), offset, data);
            return data;
        }

        @Override
        void writeToBuffer(GLBufferTarget target, Buffer data, GLBufferUsage usage) {
            GL15.glBufferData(target.glInt(), (IntBuffer) data, usage.glInt());
        }
    },

    /**
     * Float primitive buffer type corresponding to the {@link FloatBuffer}.
     */
    Float() {
        @Override
        int getByteShift() {
            return 2;
        }

        @Override
        FloatBuffer readFromBuffer(GLBufferTarget target, long offset, int length) {
            FloatBuffer data = BufferUtils.createFloatBuffer(length);
            GL15.glGetBufferSubData(target.glInt(), offset, data);
            return data;
        }

        @Override
        void writeToBuffer(GLBufferTarget target, Buffer data, GLBufferUsage usage) {
            GL15.glBufferData(target.glInt(), (FloatBuffer) data, usage.glInt());
        }
    },

    /**
     * Double primitive buffer type corresponding to the {@link DoubleBuffer}.
     */
    Double() {
        @Override
        int getByteShift() {
            return 3;
        }

        @Override
        DoubleBuffer readFromBuffer(GLBufferTarget target, long offset, int length) {
            DoubleBuffer data = BufferUtils.createDoubleBuffer(length);
            GL15.glGetBufferSubData(target.glInt(), offset, data);
            return data;
        }

        @Override
        void writeToBuffer(GLBufferTarget target, Buffer data, GLBufferUsage usage) {
            GL15.glBufferData(target.glInt(), (DoubleBuffer) data, usage.glInt());
        }
    },

    // End of enumeration
    ;

    /**
     * Returns the buffer primitive type of the specified buffer.
     *
     * @param buffer the buffer data.
     * @return buffer primitive type.
     * @throws GLBufferException when there is no match to a buffer primitive type.
     */
    public static GLBufferType getType(Buffer buffer) {
        if (ByteBuffer.class.isInstance(buffer)) {
            return GLBufferType.Byte;
        } else if (FloatBuffer.class.isInstance(buffer)) {
            return GLBufferType.Float;
        } else if (IntBuffer.class.isInstance(buffer)) {
            return GLBufferType.Integer;
        } else if (DoubleBuffer.class.isInstance(buffer)) {
            return GLBufferType.Double;
        } else if (ShortBuffer.class.isInstance(buffer)) {
            return GLBufferType.Short;
        } else {
            throw new GLBufferException("Specified buffer [" + buffer + "] is not a supported OpenGL buffer type");
        }
    }

    /**
     * Returns the byte shift value of the buffer primitive type.  This is the value used to shift the number of
     * elements to either convert to or from the number of byte elements.
     *
     * @return byte shift value.
     */
    abstract int getByteShift();

    /**
     * Converts the specified size of the buffer primitive type to the size of the buffer if it were bytes.
     *
     * @param size the size of the buffer.
     * @return the size of the byte buffer.
     */
    int toByteSize(int size) {
        return size << getByteShift();
    }

    /**
     * Converts the specified size of a byte buffer to the size of the buffer if it were of the primitive type.
     *
     * @param byteSize the size of the byte buffer.
     * @return the size of the primitive type buffer.
     */
    int fromByteSize(int byteSize) {
        return byteSize >> getByteShift();
    }

    /**
     * Reads the buffer bound to the specified target starting from the specified offset and for the specified length.
     *
     * @param target buffer target to read.
     * @param offset offset to start reading.
     * @param length length to read.
     * @return the data read from the bound buffer.
     */
    abstract Buffer readFromBuffer(GLBufferTarget target, long offset, int length);

    /**
     * Writes the specified buffer data too the buffer bound to the specified target with the specified usage pattern.
     *
     * @param target buffer target to write.
     * @param data data to write to the bound buffer.
     * @param usage usage pattern to set on the bound buffer.
     */
    abstract void writeToBuffer(GLBufferTarget target, Buffer data, GLBufferUsage usage);
}
