package com.game30.javagl.textures;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.game30.javagl.GLObjectBase;
import com.game30.javagl.programs.GLAttributeType;

/**
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLTextureBase extends GLObjectBase implements GLTexture {

    private final GLTextureTarget target;
    private final GLTextureFormat format;
    private final int width;
    private final int height;

    protected GLTextureBase(GLTextureTarget target, GLTextureFormat format, int width, int height, ByteBuffer data) {
        super(GL11.glGenTextures());
        this.target = target;
        this.format = format;
        this.width = width;
        this.height = height;
        bind();
        GL11.glTexImage2D(target.glInt(), 0, format.glInt(), width, height, 0, format.glInt(),
                          GLAttributeType.UnsignedByte.glInt(), data);

        // TODO Allow these parameters to be set outside
        GL11.glTexParameteri(target.glInt(), GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(target.glInt(), GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(target.glInt(), GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameteri(target.glInt(), GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
        unbind();
    }

    @Override
    public void delete() {
        GLTexture.super.delete();
        super.delete();
    }

    @Override
    public GLTextureTarget getTarget() {
        return target;
    }

    @Override
    public GLTextureFormat getFormat() {
        return format;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
