package com.game30.javagl.textures;

import org.lwjgl.opengl.GL11;

import com.game30.javagl.GLMagicInteger;
import com.game30.javagl.GLMagicIntegerException;

/**
 * @author Brian Norman
 * @since 1.0.0
 */
public enum GLTextureFormat implements GLMagicInteger {

    Alpha(GL11.GL_ALPHA),

    Luminance(GL11.GL_LUMINANCE),

    LuminanceAlpha(GL11.GL_LUMINANCE_ALPHA),

    RGB(GL11.GL_RGB),

    RGBA(GL11.GL_RGBA),

    // End of enumeration
    ;

    /**
     * Returns the GLTextureFormat that corresponds to the specified OpenGL magic integer.
     *
     * @param glInt the stage magic integer.
     * @return the corresponding GLTextureFormat.
     * @throws GLMagicIntegerException if the specified magic integer does not match a enumeration instance.
     */
    public static GLTextureFormat fromGLInt(int glInt) throws GLMagicIntegerException {
        // While it may not be the most elegant, switch is definitely the fastest.
        switch (glInt) {
            case GL11.GL_ALPHA:
                return GLTextureFormat.Alpha;
            case GL11.GL_LUMINANCE:
                return GLTextureFormat.Luminance;
            case GL11.GL_LUMINANCE_ALPHA:
                return GLTextureFormat.LuminanceAlpha;
            case GL11.GL_RGB:
                return GLTextureFormat.RGB;
            case GL11.GL_RGBA:
                return GLTextureFormat.RGBA;
            default:
                throw new GLMagicIntegerException("Could not match to a GLTextureFormat.");
        }
    }

    /** The OpenGL magic integer of the attribute type. */
    private final int glInt;

    /**
     * Creates a new attribute type with the specified magic integer.
     *
     * @param glInt the type magic integer.
     */
    GLTextureFormat(int glInt) {
        this.glInt = glInt;
    }

    @Override
    public int glInt() {
        return glInt;
    }
}
