package com.game30.javagl.buffers;

import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL21;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL42;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GL44;

import com.game30.javagl.GLMagicInteger;
import com.game30.javagl.GLMagicIntegerException;
import com.game30.javagl.GLMagicIntegerException;

/**
 * An enumeration of the different binding targets for an OpenGL buffer.
 *
 * @author Brian Norman
 * @see <a href="http://www.opengl.org/wiki/Buffer_Object#General_use">Buffer Targets on OpenGL wiki</a>
 * @since 1.0
 */
public enum GLBufferTarget implements GLMagicInteger {

    /**
     * The buffer will be used as a source for vertex data, but only when glVertexAttribPointer​ is called.  The pointer
     * field of this function is taken as a byte offset from the beginning of whatever buffer is currently bound to this
     * target.
     */
    Array(GL15.GL_ARRAY_BUFFER, GL15.GL_ARRAY_BUFFER_BINDING),

    /**
     * All rendering functions of the form gl*Draw*Elements*​ will use the pointer field as a byte offset from the
     * beginning of the buffer object bound to this target.  The indices used for indexed rendering will be taken from
     * the buffer object.  Note that this binding target is part of a Vertex Array Objects state, so a VAO must be bound
     * before binding a buffer here.
     */
    ElementArray(GL15.GL_ELEMENT_ARRAY_BUFFER, GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING),

    /**
     * This has no particular semantics.  Because it has no actual meaning, it is a useful target for copying buffer
     * object data with glCopyBufferSubData​.  You do not have to use this target when copying, but by using it, you
     * avoid disturbing buffer targets that have actual semantics.
     */
    CopyRead(GL31.GL_COPY_READ_BUFFER, GL31.GL_COPY_READ_BUFFER_BINDING),

    /**
     * This has no particular semantics.  Because it has no actual meaning, it is a useful target for copying buffer
     * object data with glCopyBufferSubData​.  You do not have to use this target when copying, but by using it, you
     * avoid disturbing buffer targets that have actual semantics.
     */
    CopyWrite(GL31.GL_COPY_WRITE_BUFFER, GL31.GL_COPY_WRITE_BUFFER_BINDING),

    /**
     * This is for performing asynchronous pixel transfer operations.  If a buffer is bound to PixelPack, glGetTexImage​
     * and glReadPixels​ will store their data to the bound buffer object instead of where a client pointer points.
     */
    PixelPack(GL21.GL_PIXEL_PACK_BUFFER, GL21.GL_PIXEL_PACK_BUFFER_BINDING),

    /**
     * This is for performing asynchronous pixel transfer operations.  If a buffer is bound to PixelUnpack,
     * glTexImage*​, glTexSubImage*​, glCompressedTexImage*​, and glCompressedTexSubImage*​ are all affected.  These
     * functions will read their data from the bound buffer object instead of where a client pointer points.
     */
    PixelUnpack(GL21.GL_PIXEL_UNPACK_BUFFER, GL21.GL_PIXEL_UNPACK_BUFFER_BINDING),

    /**
     * This is for performing direct writes from asynchronous queries to buffer object memory.  If a buffer is bound to
     * Query, then all glGetQueryObject​ function calls will write the result to an offset into the bound buffer
     * object.
     */
    Query(GL44.GL_QUERY_BUFFER, GL44.GL_QUERY_BUFFER_BINDING),

    /**
     * This target has no special semantics, but if you intend to use a buffer object for Buffer Textures, it is a good
     * idea to bind it here when you first create it.
     */
    Texture(GL31.GL_TEXTURE_BUFFER, GL31.GL_TEXTURE_BINDING_BUFFER),

    /**
     * An indexed buffer binding for buffers used in Transform Feedback operations.
     */
    TransformFeedback(GL30.GL_TRANSFORM_FEEDBACK_BUFFER, GL30.GL_TRANSFORM_FEEDBACK_BUFFER_BINDING),

    /**
     * An indexed buffer binding for buffers used as storage for uniform blocks.
     */
    Uniform(GL31.GL_UNIFORM_BUFFER, GL31.GL_UNIFORM_BUFFER_BINDING),

    /**
     * The buffer bound to this target will be used as the source for the indirect data when performing indirect
     * rendering.  This is only available in core OpenGL 4.0 or with ARB_draw_indirect.
     */
    DrawIndirect(GL40.GL_DRAW_INDIRECT_BUFFER, GL40.GL_DRAW_INDIRECT_BUFFER_BINDING),

    /**
     * An indexed buffer binding for buffers used as storage for atomic counters.  This requires OpenGL 4.2 or
     * ARB_shader_atomic_counters.
     */
    AtomicCounter(GL42.GL_ATOMIC_COUNTER_BUFFER, GL42.GL_ATOMIC_COUNTER_BUFFER_BINDING),

    /**
     * The buffer bound to this target will be used as the source for indirect compute dispatch operations, via
     * glDispatchComputeIndirect​.  This requires OpenGL 4.3 or ARB_compute_shader.
     */
    DispatchIndirect(GL43.GL_DISPATCH_INDIRECT_BUFFER, GL43.GL_DISPATCH_INDIRECT_BUFFER_BINDING),

    /**
     * An indexed buffer binding for buffers used as storage for shader storage blocks.  This requires OpenGL 4.3 or
     * ARB_shader_storage_buffer_object.
     */
    ShaderStorage(GL43.GL_SHADER_STORAGE_BUFFER, GL43.GL_SHADER_STORAGE_BUFFER_BINDING),

    // End of enumeration
    ;

    /**
     * Returns the {@link GLBufferTarget} that corresponds to the specified OpenGL
     * magic integer.
     *
     * @param glInt the target magic integer.
     * @return the corresponding {@link GLBufferTarget}.
     * @throws com.game30.javagl.GLMagicIntegerException if the specified magic integer does not match a
     * enumeration instance.
     */
    public static GLBufferTarget fromGLInt(int glInt) throws GLMagicIntegerException {
        // While it may not be the most elegant, switch is definitely the fastest.
        switch (glInt) {
            case GL15.GL_ARRAY_BUFFER:
                return GLBufferTarget.Array;
            case GL15.GL_ELEMENT_ARRAY_BUFFER:
                return GLBufferTarget.ElementArray;
            case GL31.GL_COPY_READ_BUFFER:
                return GLBufferTarget.CopyRead;
            case GL31.GL_COPY_WRITE_BUFFER:
                return GLBufferTarget.CopyWrite;
            case GL21.GL_PIXEL_PACK_BUFFER:
                return GLBufferTarget.PixelPack;
            case GL21.GL_PIXEL_UNPACK_BUFFER:
                return GLBufferTarget.PixelUnpack;
            case GL44.GL_QUERY_BUFFER:
                return GLBufferTarget.Query;
            case GL31.GL_TEXTURE_BUFFER:
                return GLBufferTarget.Texture;
            case GL30.GL_TRANSFORM_FEEDBACK_BUFFER:
                return GLBufferTarget.TransformFeedback;
            case GL31.GL_UNIFORM_BUFFER:
                return GLBufferTarget.Uniform;
            case GL40.GL_DRAW_INDIRECT_BUFFER:
                return GLBufferTarget.DrawIndirect;
            case GL42.GL_ATOMIC_COUNTER_BUFFER:
                return GLBufferTarget.AtomicCounter;
            case GL43.GL_DISPATCH_INDIRECT_BUFFER:
                return GLBufferTarget.DispatchIndirect;
            case GL43.GL_SHADER_STORAGE_BUFFER:
                return GLBufferTarget.ShaderStorage;
            default:
                throw new GLMagicIntegerException("Could not match to a GLBufferTarget.");
        }
    }

    /**
     * Returns the {@link GLBufferTarget} that corresponds to the specified OpenGL
     * magic binding integer.
     *
     * @param binding the target magic binding integer.
     * @return the corresponding {@link GLBufferTarget}.
     * @throws com.game30.javagl.GLMagicIntegerException if the specified magic integer does not match a
     * enumeration instance.
     */
    public static GLBufferTarget fromBinding(int binding) throws GLMagicIntegerException {
        // While it may not be the most elegant, switch is definitely the fastest.
        switch (binding) {
            case GL15.GL_ARRAY_BUFFER_BINDING:
                return GLBufferTarget.Array;
            case GL15.GL_ELEMENT_ARRAY_BUFFER_BINDING:
                return GLBufferTarget.ElementArray;
            case GL31.GL_COPY_READ_BUFFER_BINDING:
                return GLBufferTarget.CopyRead;
            case GL31.GL_COPY_WRITE_BUFFER_BINDING:
                return GLBufferTarget.CopyWrite;
            case GL21.GL_PIXEL_PACK_BUFFER_BINDING:
                return GLBufferTarget.PixelPack;
            case GL21.GL_PIXEL_UNPACK_BUFFER_BINDING:
                return GLBufferTarget.PixelUnpack;
            case GL44.GL_QUERY_BUFFER_BINDING:
                return GLBufferTarget.Query;
            case GL31.GL_TEXTURE_BINDING_BUFFER:
                return GLBufferTarget.Texture;
            case GL30.GL_TRANSFORM_FEEDBACK_BUFFER_BINDING:
                return GLBufferTarget.TransformFeedback;
            case GL31.GL_UNIFORM_BUFFER_BINDING:
                return GLBufferTarget.Uniform;
            case GL40.GL_DRAW_INDIRECT_BUFFER_BINDING:
                return GLBufferTarget.DrawIndirect;
            case GL42.GL_ATOMIC_COUNTER_BUFFER_BINDING:
                return GLBufferTarget.AtomicCounter;
            case GL43.GL_DISPATCH_INDIRECT_BUFFER_BINDING:
                return GLBufferTarget.DispatchIndirect;
            case GL43.GL_SHADER_STORAGE_BUFFER_BINDING:
                return GLBufferTarget.ShaderStorage;
            default:
                throw new GLMagicIntegerException("Could not match to a GLBufferTarget.");
        }
    }

    /** The OpenGL magic integer of the target. */
    private final int glInt;

    /** The OpenGL magic binding integer of the target. */
    private final int binding;

    /**
     * Creates a new buffer target with the specified magic integer.
     *
     * @param glInt the target magic integer.
     * @param binding the target magic binding integer.
     */
    GLBufferTarget(int glInt, int binding) {
        this.glInt = glInt;
        this.binding = binding;
    }

    @Override
    public int glInt() {
        return glInt;
    }

    /**
     * Returns the OpenGL magic binding integer of the target.
     *
     * @return the OpenGL magic binding integer.
     */
    public int binding() {
        return binding;
    }
}
