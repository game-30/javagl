package com.game30.javagl.programs;

import org.lwjgl.opengl.GL11;

import com.game30.javagl.GLMagicInteger;
import com.game30.javagl.GLMagicIntegerException;

/**
 * An enumeration of the different primitive types which an OpenGL program attribute can be.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public enum GLAttributeType implements GLMagicInteger {

    /**
     * Unsigned byte primitive attribute type.
     */
    UnsignedByte(GL11.GL_UNSIGNED_BYTE),

    /**
     * Byte primitive attribute type.
     */
    Byte(GL11.GL_BYTE),

    /**
     * Unsigned short primitive attribute type.
     */
    UnsignedShort(GL11.GL_UNSIGNED_SHORT),

    /**
     * Short primitive attribute type.
     */
    Short(GL11.GL_SHORT),

    /**
     * Unsigned integer primitive attribute type.
     */
    UnsignedInt(GL11.GL_UNSIGNED_INT),

    /**
     * Integer primitive attribute type.
     */
    Int(GL11.GL_INT),

    /**
     * Float primitive attribute type.
     */
    Float(GL11.GL_FLOAT),

    /**
     * Double primitive attribute type.
     */
    Double(GL11.GL_DOUBLE),

    // End of enumeration
    ;

    /**
     * Returns the GLAttributeType that corresponds to the specified OpenGL magic integer.
     *
     * @param glInt the stage magic integer.
     * @return the corresponding GLAttributeType.
     * @throws GLMagicIntegerException if the specified magic integer does not match a enumeration instance.
     */
    public static GLAttributeType fromGLInt(int glInt) throws GLMagicIntegerException {
        // While it may not be the most elegant, switch is definitely the fastest.
        switch (glInt) {
            case GL11.GL_UNSIGNED_BYTE:
                return GLAttributeType.UnsignedByte;
            case GL11.GL_BYTE:
                return GLAttributeType.Byte;
            case GL11.GL_UNSIGNED_SHORT:
                return GLAttributeType.UnsignedShort;
            case GL11.GL_SHORT:
                return GLAttributeType.Short;
            case GL11.GL_UNSIGNED_INT:
                return GLAttributeType.UnsignedInt;
            case GL11.GL_INT:
                return GLAttributeType.Int;
            case GL11.GL_FLOAT:
                return GLAttributeType.Float;
            case GL11.GL_DOUBLE:
                return GLAttributeType.Double;
            default:
                throw new GLMagicIntegerException("Could not match to a GLAttributeType.");
        }
    }

    /** The OpenGL magic integer of the attribute type. */
    private final int glInt;

    /**
     * Creates a new attribute type with the specified magic integer.
     *
     * @param glInt the type magic integer.
     */
    GLAttributeType(int glInt) {
        this.glInt = glInt;
    }

    @Override
    public int glInt() {
        return glInt;
    }
}
