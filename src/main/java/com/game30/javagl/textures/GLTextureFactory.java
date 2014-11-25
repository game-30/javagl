package com.game30.javagl.textures;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

/**
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public interface GLTextureFactory {

    static GLTextureFactory createDefault() {
        return GLTextureBase::new;
    }


    GLTexture create(GLTextureTarget target, GLTextureFormat format, int width, int height, ByteBuffer data);

    default GLTexture create(GLTextureTarget target, GLTextureFormat format, int square, ByteBuffer data) {
        return create(target, format, square, square, data);
    }

    default GLTexture create(GLTextureTarget target, GLTextureFormat format, int width, int height, byte[] data) {
        final ByteBuffer buffer = BufferUtils.createByteBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return create(target, format, width, height, buffer);
    }

    default GLTexture create(GLTextureTarget target, GLTextureFormat format, int square, byte[] data) {
        return create(target, format, square, square, data);
    }
}
