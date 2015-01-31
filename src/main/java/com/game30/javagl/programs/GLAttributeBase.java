package com.game30.javagl.programs;

/**
 * Base class for {@link GLAttribute}s.  This provides basic attribute property behavior.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLAttributeBase implements GLAttribute {

    /** The attribute index. */
    private final int index;

    /** The attribute name. */
    private final String name;

    /** The attribute size. */
    private int size;

    /** The attribute primitive type. */
    private GLAttributeType type;

    /** If the attribute is normalized. */
    private boolean normalized;

    /** The attribute stride. */
    private int stride;

    /** The attribute offset. */
    private int offset;

    /**
     * Constructs a GLAttributeBase instance with the specified index and name, using the default values for the rest of
     * the attribute properties.
     *
     * @param index the attribute index.
     * @param name the attribute name.
     */
    protected GLAttributeBase(int index, CharSequence name) {
        this.index = index;
        this.name = name.toString();
        this.size = GLAttribute.DEFAULT_SIZE;
        this.type = GLAttribute.DEFAULT_TYPE;
        this.normalized = GLAttribute.DEFAULT_NORMALIZED;
        this.stride = GLAttribute.DEFAULT_STRIDE;
        this.offset = GLAttribute.DEFAULT_OFFSET;
    }

    /**
     * Constructs a GLAttributeBase instance with the specified index, name, and all of the attribute properties.
     *
     * @param index the attribute index.
     * @param name the attribute name.
     * @param size the attribute size.
     * @param type the attribute type.
     * @param normalized if the attribute is normalized.
     * @param stride the attribute stride.
     * @param offset the attribute offset.
     */
    protected GLAttributeBase(int index, CharSequence name, int size, GLAttributeType type, boolean normalized,
                              int stride, int offset) {
        this(index, name);
        this.size = size;
        this.type = type;
        this.normalized = normalized;
        this.stride = stride;
        this.offset = offset;
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
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public GLAttributeType getType() {
        return type;
    }

    @Override
    public void setType(GLAttributeType type) {
        this.type = type;
    }

    @Override
    public boolean isNormalized() {
        return normalized;
    }

    @Override
    public void setNormalized(boolean normalized) {
        this.normalized = normalized;
    }

    @Override
    public int getStride() {
        return stride;
    }

    @Override
    public void setStride(int stride) {
        this.stride = stride;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
