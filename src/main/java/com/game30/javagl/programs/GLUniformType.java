package com.game30.javagl.programs;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL21;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL40;

/**
 * An enumeration of the different uniform types available in the OpenGL Scripting Language.
 *
 * <p />This is sort of a hack class that gets around the restrictive nature of the LWJGL methods requires a different
 * method for each uniform type.  Each of the uniform types defined in this enumeration knows which method it needs to
 * call write a generic {@link Buffer} to the uniform.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public enum GLUniformType {

    /**
     * An integer array uniform type of length 1.
     */
    Integer(1) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform1(position, (IntBuffer) data);
        }
    },

    /**
     * An integer array uniform type of length 2.
     */
    Integer2(2) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform2(position, (IntBuffer) data);
        }
    },

    /**
     * An integer array uniform type of length 3.
     */
    Integer3(3) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform3(position, (IntBuffer) data);
        }
    },

    /**
     * An integer array uniform type of length 4.
     */
    Integer4(4) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform4(position, (IntBuffer) data);
        }
    },

    /**
     * An unsigned integer array uniform type of length 1.
     */
    UnsignedInteger(1) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL30.glUniform1u(position, (IntBuffer) data);
        }
    },

    /**
     * An unsigned integer array uniform type of length 2.
     */
    UnsignedInteger2(2) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL30.glUniform2u(position, (IntBuffer) data);
        }
    },

    /**
     * An unsigned integer array uniform type of length 3.
     */
    UnsignedInteger3(3) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL30.glUniform3u(position, (IntBuffer) data);
        }
    },

    /**
     * An unsigned integer array uniform type of length 4.
     */
    UnsignedInteger4(4) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL30.glUniform4u(position, (IntBuffer) data);
        }
    },

    /**
     * A float array uniform type of length 1.
     */
    Float(1) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform1(position, (FloatBuffer) data);
        }
    },

    /**
     * A float array uniform type of length 2.
     */
    Float2(2) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform2(position, (FloatBuffer) data);
        }
    },

    /**
     * A float array uniform type of length 3.
     */
    Float3(3) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform3(position, (FloatBuffer) data);
        }
    },

    /**
     * A float array uniform type of length 4.
     */
    Float4(4) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniform4(position, (FloatBuffer) data);
        }
    },

    /**
     * A float square matrix uniform type of size 2 by 2.
     */
    FloatMatrix2(4) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniformMatrix2(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float square matrix uniform type of size 3 by 3.
     */
    FloatMatrix3(9) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniformMatrix3(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float square matrix uniform type of size 4 by 4.
     */
    FloatMatrix4(16) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL20.glUniformMatrix4(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float matrix uniform type of size 2 by 3.
     */
    FloatMatrix2x3(6) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL21.glUniformMatrix2x3(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float matrix uniform type of size 3 by 2.
     */
    FloatMatrix3x2(6) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL21.glUniformMatrix3x2(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float matrix uniform type of size 2 by 4.
     */
    FloatMatrix2x4(8) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL21.glUniformMatrix2x4(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float matrix uniform type of size 4 by 2.
     */
    FloatMatrix4x2(8) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL21.glUniformMatrix4x2(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float matrix uniform type of size 3 by 4.
     */
    FloatMatrix3x4(12) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL21.glUniformMatrix3x4(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A float matrix uniform type of size 4 by 3.
     */
    FloatMatrix4x3(12) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL21.glUniformMatrix4x3(position, false, (FloatBuffer) data);
        }
    },

    /**
     * A double array uniform type of length 1.
     */
    Double(1) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniform1(position, (DoubleBuffer) data);
        }
    },

    /**
     * A double array uniform type of length 2.
     */
    Double2(2) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniform2(position, (DoubleBuffer) data);
        }
    },

    /**
     * A double array uniform type of length 3.
     */
    Double3(3) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniform3(position, (DoubleBuffer) data);
        }
    },

    /**
     * A double array uniform type of length 4.
     */
    Double4(4) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniform4(position, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 2 by 2.
     */
    DoubleMatrix2(4) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix2(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 3 by 3.
     */
    DoubleMatrix3(16) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix3(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 4 by 4.
     */
    DoubleMatrix4(16) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix4(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 2 by 3.
     */
    DoubleMatrix2x3(6) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix2x3(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 3 by 2.
     */
    DoubleMatrix3x2(6) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix3x2(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 2 by 4.
     */
    DoubleMatrix2x4(8) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix2x4(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 4 by 2.
     */
    DoubleMatrix4x2(8) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix4x2(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 3 by 4.
     */
    DoubleMatrix3x4(12) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix3x4(position, false, (DoubleBuffer) data);
        }
    },

    /**
     * A double square matrix uniform type of size 4 by 3.
     */
    DoubleMatrix4x3(12) {
        @Override
        void writeUniform(int position, Buffer data) {
            GL40.glUniformMatrix4x3(position, false, (DoubleBuffer) data);
        }
    },

    // End of enumeration
    ;

    /** The size of the. */
    private final int size;

    /**
     * Creates a new with the specified size.
     *
     * @param size the uniform size.
     */
    GLUniformType(int size) {
        this.size = size;
    }

    /**
     * The number of primitive values associated with the uniform type.
     *
     * @return the size of the uniform.
     */
    int getSize() {
        return size;
    }

    /**
     * Writes the specified buffer data to the uniform at the specified position.
     *
     * @param position the position of the uniform.
     * @param data the uniform data to be written.
     */
    abstract void writeUniform(int position, Buffer data);
}
