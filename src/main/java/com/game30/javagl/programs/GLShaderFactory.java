package com.game30.javagl.programs;

import java.io.IOException;
import java.nio.file.Path;

/**
 * A factory interface for {@link GLShader}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLShaderFactory {

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
    GLShader create(GLShaderStage stage, CharSequence source);

    /**
     * Creates a new OpenGL shader from the specified parameters.
     *
     * @param stage the shader pipeline stage.
     * @param path the shader source code path.
     * @return a new OpenGL shader.
     */
    GLShader create(GLShaderStage stage, Path path) throws IOException;
}
