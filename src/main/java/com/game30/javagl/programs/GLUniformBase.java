package com.game30.javagl.programs;

import java.util.Objects;

/**
 * Base class for {@link GLUniform}s.  This provides basic uniform property behavior.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLUniformBase implements GLUniform {

    /** The uniform index. */
    private final int index;

    /** The uniform name. */
    private final String name;

    /** The uniform type. */
    private GLUniformType type;

    /**
     * Constructs a GLUniformBase instance with the specified index and name, using the default values for the rest of
     * the uniform properties.
     *
     * @param index the uniform index.
     * @param name the uniform name.
     */
    protected GLUniformBase(int index, CharSequence name) {
        this.index = index;
        this.name = name.toString();
        this.type = GLUniform.DEFAULT_TYPE;
    }

    /**
     * Constructs a GLUniformBase with the specified index, name and type.
     *
     * @param index the uniform index.
     * @param name the uniform name.
     * @param type the uniform type.
     */
    protected GLUniformBase(int index, CharSequence name, GLUniformType type) {
        this(index, name);
        this.type = type;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GLUniformType getType() {
        return type;
    }

    @Override
    public void setType(GLUniformType type) {
        Objects.requireNonNull(type);
        this.type = type;
    }
}
