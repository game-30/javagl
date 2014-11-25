package com.game30.javagl.textures;

import org.lwjgl.opengl.GL11;

import com.game30.javagl.GLDeletable;
import com.game30.javagl.GLIndexed;
import com.game30.javagl.GLObject;

/**
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLTexture extends GLObject {

    static void unbindTarget(GLTextureTarget target) {
        GL11.glBindTexture(target.glInt(), GLIndexed.NULL_INDEX);
    }

    static void disableTarget(GLTextureTarget target) {
        GL11.glDisable(target.glInt());
    }


    @Override
    int getIndex();

    @Override
    default boolean exists() {
        return GL11.glIsTexture(getIndex());
    }

    @Override
    default void delete() {
        GL11.glDeleteTextures(getIndex());
    }

    @Override
    default void bind() {
        GLDeletable.requireExists(this);
        GL11.glBindTexture(getTarget().glInt(), getIndex());
    }

    @Override
    default void unbind() {
        unbindTarget(getTarget());
    }

    default void enable() {
        GLDeletable.requireExists(this);
        GL11.glEnable(getTarget().glInt());
    }

    default void disable() {
        disableTarget(getTarget());
    }

    GLTextureTarget getTarget();

    GLTextureFormat getFormat();

    int getWidth();

    int getHeight();
}
