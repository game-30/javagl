package com.game30.javagl.programs;

/**
 * A factory interface for {@link GLUniform}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLUniformFactory {

    /**
     * Returns the default OpenGL uniform factory.
     *
     * @return default uniform factory.
     */
    static GLUniformFactory getDefault() {
        return GLUniformBase::new;
    }


    /**
     * Creates a new OpenGL uniform from the specified parameters.
     *
     * @param index the uniform index.
     * @param name the uniform name.
     * @return a new OpenGL uniform.
     */
    GLUniform create(int index, CharSequence name);
}
