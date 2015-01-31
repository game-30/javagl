package com.game30.javagl.arrays;

import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import com.game30.javagl.GLDeletable;
import com.game30.javagl.GLIndexed;
import com.game30.javagl.GLObject;
import com.game30.javagl.buffers.GLBuffer;
import com.game30.javagl.programs.GLAttribute;

/**
 * A vertex array can combine multiple buffers by attaching them to specific attributes of an OpenGL program.  A vertex
 * array does not store the contents of the buffers, only a reference.  If the contents of the referenced buffers
 * changes, those changes will be seen by the users of the vertex array.
 *
 * @author Brian Norman
 * @see <a href="https://www.opengl.org/wiki/Vertex_Specification#Vertex_Array_Object">Vertex Array Object</a> on the
 * OpenGL wiki
 * @since 1.0.0
 */
public interface GLVertexArray extends GLObject {

    static void unbindAny() {
        GL30.glBindVertexArray(GLIndexed.NULL_INDEX);
    }


    /**
     * {@inheritDoc}
     *
     * <p>Default implementation is to request of OpenGL if the vertex array exists.
     */
    @Override
    default boolean exists() {
        return GL30.glIsVertexArray(getIndex());
    }

    /**
     * {@inheritDoc}
     *
     * <p>Default implementation is to request OpenGL to delete it.
     */
    @Override
    default void delete() {
        if (exists()) {
            GL30.glDeleteVertexArrays(getIndex());
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>Default implementation is to require existence then request OpenGL to bind the vertex array to the context.
     */
    @Override
    default void bind() {
        GLDeletable.requireExists(this);
        GL30.glBindVertexArray(getIndex());
    }

    /**
     * {@inheritDoc}
     *
     * <p>Default implementation is to unbind any vertex array currently bound to the context.
     */
    @Override
    default void unbind() {
        unbindAny();
    }

    /**
     * Enables the specified OpenGL GLSL program attribute.
     *
     * <p>Default implementation is to bind the vertex array then enable the attribute index.
     *
     * @param attribute the OpenGL GLSL program attribute to enable for this vertex array.
     */
    default void enable(GLAttribute attribute) {
        bind();
        GL20.glEnableVertexAttribArray(attribute.getIndex());
    }

    /**
     * Disables the specified OpenGL GLSL program attribute.
     *
     * <p>Default implementation is to bind the vertex array then disable the attribute index.
     *
     * @param attribute the OpenGL GLSL program attribute to disable for this vertex array.
     */
    default void disable(GLAttribute attribute) {
        bind();
        GL20.glDisableVertexAttribArray(attribute.getIndex());
    }

    /**
     * Attaches the specified OpenGL buffer to the specified OpenGL GLSL program attribute.
     *
     * <p>Default implementation is to enable the attribute index, bind the specified buffer, set the vertex attribute
     * pointer, then unbind the specified buffer.
     *
     * @param attribute the OpenGL GLSL program attribute to attach a OpenGL buffer.
     * @param buffer the OpenGL buffer to attach.
     */
    default void attach(GLAttribute attribute, GLBuffer buffer) {
        enable(attribute);
        buffer.bind();
        GL20.glVertexAttribPointer(attribute.getIndex(), attribute.getSize(), attribute.getType().glInt(),
                                   attribute.isNormalized(), attribute.getStride(), attribute.getOffset());
        buffer.unbind();
    }
}
