package com.game30.javagl.textures;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import com.game30.javagl.GLMagicInteger;
import com.game30.javagl.GLMagicIntegerException;

/**
 * @author Brian Norman
 * @since 1.0.0
 */
public enum GLTextureTarget implements GLMagicInteger {

    Texture2D(GL11.GL_TEXTURE_2D),

    ProxyTexture2D(GL11.GL_PROXY_TEXTURE_2D),

    TextureCubMapPositiveX(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_X),

    TextureCubMapNegativeX(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_X),

    TextureCubMapPositiveY(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Y),

    TextureCubMapNegativeY(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y),

    TextureCubMapPositiveZ(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Z),

    TextureCubMapNegativeZ(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z),

    TextureCubeMap(GL13.GL_TEXTURE_CUBE_MAP),

    // End of enumeration
    ;

    /**
     * Returns the GLTextureTarget that corresponds to the specified OpenGL magic integer.
     *
     * @param glInt the stage magic integer.
     * @return the corresponding GLTextureTarget.
     * @throws GLMagicIntegerException if the specified magic integer does not match a enumeration instance.
     */
    public static GLTextureTarget fromGLInt(int glInt) throws GLMagicIntegerException {
        // While it may not be the most elegant, switch is definitely the fastest.
        switch (glInt) {
            case GL11.GL_TEXTURE_2D:
                return GLTextureTarget.Texture2D;
            case GL11.GL_PROXY_TEXTURE_2D:
                return GLTextureTarget.ProxyTexture2D;
            case GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_X:
                return GLTextureTarget.TextureCubMapPositiveX;
            case GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_X:
                return GLTextureTarget.TextureCubMapNegativeX;
            case GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Y:
                return GLTextureTarget.TextureCubMapPositiveY;
            case GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y:
                return GLTextureTarget.TextureCubMapNegativeY;
            case GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Z:
                return GLTextureTarget.TextureCubMapPositiveZ;
            case GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z:
                return GLTextureTarget.TextureCubMapNegativeZ;
            case GL13.GL_TEXTURE_CUBE_MAP:
                return GLTextureTarget.TextureCubeMap;
            default:
                throw new GLMagicIntegerException("Could not match to a GLTextureTarget.");
        }
    }

    /** The OpenGL magic integer of the attribute type. */
    private final int glInt;

    /**
     * Creates a new attribute type with the specified magic integer.
     *
     * @param glInt the type magic integer.
     */
    GLTextureTarget(int glInt) {
        this.glInt = glInt;
    }

    @Override
    public int glInt() {
        return glInt;
    }
}
