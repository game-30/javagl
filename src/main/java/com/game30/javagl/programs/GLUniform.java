package com.game30.javagl.programs;

import java.nio.Buffer;

/**
 * A GLUniform represents a uniform of a OpenGL Scripting Language (GLSL) program.  A uniform is a way for a specific
 * value to be <strong>uniform</strong> across all attribute vertexes.  One example is to use a uniform for the model,
 * view, and/or the perspective transformation matrices.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLUniform {

    /** The initial value of the uniform type. */
    GLUniformType DEFAULT_TYPE = GLUniformType.Float;


    /**
     * Returns the index of the GLSL program uniform.
     *
     * @return the uniform index.
     */
    int getIndex();

    /**
     * Returns the name of the GLSL program uniform.
     *
     * @return the uniform name.
     */
    String getName();

    /**
     * Returns the primitive variable type of the GLSL program uniform.
     *
     * @return the uniform variable type.
     */
    GLUniformType getType();

    /**
     * Sets the primitive variable type of the GLSL program uniform.
     *
     * @param type the uniform variable type.
     */
    void setType(GLUniformType type);

    /**
     * Writes data to the GLSL program uniform. 1
     *
     * @param data data to write.
     */
    default void write(Buffer data) {
        if (data.remaining() != getType().getSize()) {
            throw new GLUniformException("Remaining data in data buffer does not match needed data for " + this);
        }
        getType().writeUniform(getIndex(), data);
    }
}
