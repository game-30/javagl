package com.game30.javagl.programs;

/**
 * A factory interface for {@link GLShader}s.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public interface GLShaderFactory {

    /**
     * Returns the default OpenGL shader factory.
     *
     * @return default shader factory.
     */
    static GLShaderFactory getDefault() {
        return GLShaderBase::new;
    }


    /**
     * Creates a new OpenGL shader from the specified parameters.
     *
     * @param stage the shader pipeline stage.
     * @return a new OpenGL shader.
     */
    GLShader create(GLShaderStage stage);

    /**
     * Creates a new OpenGL shader from the specified parameters.
     *
     * @param stage the shader pipeline stage.
     * @param source the shader source code.
     * @return a new OpenGL shader.
     */
    default GLShader create(GLShaderStage stage, CharSequence source) {
        final GLShader shader = create(stage);
        shader.setSource(source);
        return shader;
    }
}
