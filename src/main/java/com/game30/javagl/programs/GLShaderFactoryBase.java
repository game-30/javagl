package com.game30.javagl.programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The base factory implementation for {@link GLShader}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLShaderFactoryBase implements GLShaderFactory {

    @Override
    public GLShader create(GLShaderStage stage) {
        return new GLShaderBase(stage);
    }

    @Override
    public GLShader create(GLShaderStage stage, CharSequence source) {
        final GLShader shader = create(stage);
        shader.setSource(source);
        return shader;
    }

    @Override
    public GLShader create(GLShaderStage stage, Path path) throws IOException {
        StringBuilder shaderSource = new StringBuilder();
        Files.lines(path).forEach(l -> shaderSource.append(l).append('\n'));
        GLShader shader = create(stage, shaderSource);
        shader.compile();
        return shader;
    }
}
