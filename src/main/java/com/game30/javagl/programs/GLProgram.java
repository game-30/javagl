package com.game30.javagl.programs;

import java.util.Collection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import com.game30.javagl.GLDeletable;

/**
 * A program object can combine multiple shader stages (built from the shader objects) into a single, linked whole.  A
 * program pipeline object can combine programs that contain individual shader stages into a whole pipeline.
 *
 * @author Brian Norman
 * @see <a href="http://www.opengl.org/wiki/GLSL_Object">Program</a> on the OpenGL wiki
 * @since 1.0.0
 */
public interface GLProgram extends GLSLObject {

    /**
     * {@inheritDoc}
     *
     * <p />Default implementation is to query OpenGL for the integer representation of the delete status of the program
     * and compare it to the OpenGL magic integer {@link GL11#GL_TRUE}.
     */
    @Override
    default boolean exists() {
        return GL20.glGetProgrami(getIndex(), GL20.GL_DELETE_STATUS) == GL11.GL_TRUE;
    }

    /**
     * {@inheritDoc}
     *
     * <p />Default implementation is to request OpenGL to delete it.
     */
    @Override
    default void delete() {
        if (exists()) {
            GL20.glDeleteProgram(getIndex());
        }
    }

    default void use() {
        GL20.glUseProgram(getIndex());
    }

    default void link() {
        GL20.glLinkProgram(getIndex());
    }

    default boolean getLinkStatus() {
        return GL20.glGetProgrami(getIndex(), GL20.GL_LINK_STATUS) == GL11.GL_TRUE;
    }

    default void validate() {
        GL20.glValidateProgram(getIndex());
    }

    default boolean getValidateStatus() {
        return GL20.glGetProgrami(getIndex(), GL20.GL_VALIDATE_STATUS) == GL11.GL_TRUE;
    }

    /**
     * Returns the information log of the program.  The information log is a log of the program linking or validation.
     * If linking or validation failed, this log will contain details as to why they failed.
     *
     * <p />Default implementation is to query OpenGL for the length of the log.  Using this as the max length, query
     * OpenGL again for a buffer which is converted to a {@code String}.
     *
     * @return the information log of the program.
     */
    default String getInfoLog() {
        GLDeletable.requireExists(this);
        return GL20.glGetProgramInfoLog(getIndex(), GL20.glGetShaderi(getIndex(), GL20.GL_INFO_LOG_LENGTH));
    }

    /**
     * Attaches the specified {@link GLShader} object to the program.  Shaders that are to be linked together in a
     * program object must first be attached to that program object.
     *
     * <p />Default implementation TODO
     *
     * @param shader the {@link GLShader} to attach.
     */
    default void attach(GLShader shader) {
        GL20.glAttachShader(getIndex(), shader.getIndex());
    }

    /**
     * Detaches the specified {@link GLShader} object from the program.
     *
     * <p />Default implementation TODO
     *
     * @param shader the the {@link GLShader} to detach.
     */
    default void detach(GLShader shader) {
        GL20.glDetachShader(getIndex(), shader.getIndex());
    }

    /**
     * Returns the {@link GLShader} objects that are attached to the program.
     *
     * @return the attached {@link GLShader}s.
     */
    Collection<GLShader> getShaders();

    default int getAttributeIndex(CharSequence name) {
        int index = GL20.glGetAttribLocation(getIndex(), name);
        if (index >= 0) {
            return index;
        } else {
            throw new GLProgramException("Attribute [" + name + "] does not exist");
        }
    }

    GLAttribute getAttribute(CharSequence name);

    default int getUniformIndex(CharSequence name) {
        int index = GL20.glGetUniformLocation(getIndex(), name);
        if (index >= 0) {
            return index;
        } else {
            throw new GLProgramException("Uniform [" + name + "] does not exist");
        }
    }

    GLUniform getUniform(CharSequence name);
}
