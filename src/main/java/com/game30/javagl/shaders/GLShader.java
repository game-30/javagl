package com.game30.javagl.shaders;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import com.game30.javagl.GLDeletable;

/**
 * A program designed to run at some stage of the graphics processor.  Its purpose is to execute one of the programmable
 * stages of the rendering pipeline.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @see <a href="http://www.opengl.org/wiki/Shader">Shader</a> on the OpenGL wiki
 * @since 1.0.0
 */
public interface GLShader extends GLSLObject {

    /**
     * {@inheritDoc}
     *
     * <p />Default implementation is to request OpenGL to delete it.
     */
    @Override
    default void delete() {
        GL20.glDeleteShader(getIndex());
    }

    /**
     * {@inheritDoc}
     *
     * <p />Default implementation is to query OpenGL for the integer representation of the delete status of the shader
     * and compare it to the OpenGL magic integer {@link GL11#GL_TRUE}.
     */
    @Override
    default boolean exists() {
        return GL20.glGetShaderi(getIndex(), GL20.GL_DELETE_STATUS) == GL11.GL_TRUE;
    }

    /**
     * Returns the stage of the shader.  The possible stages are enumerated by {@link GLShaderStage}.
     *
     * <p />Default implementation is to query OpenGL for the integer representation of the stage and convert it to a
     * {@link GLShaderStage}.
     *
     * @return the stage of the shader.
     */
    default GLShaderStage getStage() {
        GLDeletable.requireExists(this);
        return GLShaderStage.fromGLInt(GL20.glGetShaderi(getIndex(), GL20.GL_SHADER_TYPE));
    }

    /**
     * Sets the source of the shader.
     *
     * <p />Default implementation is to pass the source to OpenGL as the source of the shader.
     *
     * @param source the source of the shader.
     */
    default void setSource(CharSequence source) {
        GL20.glShaderSource(getIndex(), source);
    }

    /**
     * Returns the source of the shader as a {@code String}.
     *
     * <p />Default Implementation is to query OpenGL for the length of the source.  Using this as the max length, query
     * OpenGL again for a buffer which is converted to a {@code String}.
     *
     * @return the source of the shader.
     */
    default String getSource() {
        GLDeletable.requireExists(this);
        return GL20.glGetShaderSource(getIndex(), GL20.glGetShaderi(getIndex(), GL20.GL_SHADER_SOURCE_LENGTH));
    }

    /**
     * Compiles the shader into a usable program.
     *
     * <p />Default implementation is to invoke {@link GL20#glCompileShader(int)} with the shader index.
     */
    default void compile() {
        GLDeletable.requireExists(this);
        GL20.glCompileShader(getIndex());
    }

    /**
     * Returns the status form the last shader compilation attempt.
     *
     * <p />Default implementation is to return {@code true} if the shader was successfully compiled; {@code false}
     * otherwise.
     *
     * @return the status of the shader compilation.
     */
    default boolean getCompileStatus() {
        GLDeletable.requireExists(this);
        return GL20.glGetShaderi(getIndex(), GL20.GL_COMPILE_STATUS) == GL11.GL_TRUE;
    }

    /**
     * Returns the information log of the shader.  The information log is a log of the shader compilation.  If
     * compilation failed, this log will contain details as to why it failed.
     *
     * <p />Default implementation is to query OpenGL for the length of the log.  Using this as the max length, query
     * OpenGL again for a buffer which is converted to a {@code String}.
     *
     * @return the information log of the shader.
     */
    default String getInfoLog() {
        GLDeletable.requireExists(this);
        return GL20.glGetShaderInfoLog(getIndex(), GL20.glGetShaderi(getIndex(), GL20.GL_INFO_LOG_LENGTH));
    }
}
