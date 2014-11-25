package com.game30.javagl.arrays;

import org.lwjgl.opengl.GL30;

import com.game30.javagl.GLObjectBase;

/**
 * Base class for {@link GLVertexArray}s.  This provides basic index and existence behavior.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLVertexArrayBase extends GLObjectBase implements GLVertexArray {

    /**
     * Constructs a GLVertexArrayBase instance.
     */
    protected GLVertexArrayBase() {
        super(GL30.glGenVertexArrays());
    }

    @Override
    public void delete() {
        GLVertexArray.super.delete();
        super.delete();
    }
}
