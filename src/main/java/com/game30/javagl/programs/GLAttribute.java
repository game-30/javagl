package com.game30.javagl.programs;

/**
 * A GLAttribute represents an attribute of a OpenGL Scripting Language (GLSL) program.  The attribute can be customized
 * in the way that it reads a buffer from the graphics card memory.  Only one instance of an attribute should exist for
 * each attribute of a GLSL program so that modifications made to an attribute are maintained across holders of the
 * instance.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLAttribute {

    /** The initial value of the attribute size. */
    int DEFAULT_SIZE = 4;

    /** The initial value of the attribute type. */
    GLAttributeType DEFAULT_TYPE = GLAttributeType.Float;

    /** The initial value of the attribute normalization. */
    boolean DEFAULT_NORMALIZED = false;

    /** The initial value of the attribute stride. */
    int DEFAULT_STRIDE = 0;

    /** The initial value of the attribute offset. */
    int DEFAULT_OFFSET = 0;


    /**
     * Returns the index of the GLSL program attribute.
     *
     * @return the attribute index.
     */
    int getIndex();

    /**
     * Returns the name of the GLSL program attribute.
     *
     * @return the attribute name.
     */
    String getName();

    /**
     * Returns the array size of the GLSL program attribute.  This is used to indicate how many instances of the
     * attribute type are contained in a single variable.  In other words, a size of {@code 2} indicates that this
     * attribute is a 2 dimensional vector.
     *
     * @return the attribute array size.
     */
    int getSize();

    /**
     * Sets the array size of the GLSL program attribute.  This is used to indicate how many instances of the attribute
     * type are contained in a single variable.  In other words, a size of {@code 2} indicates that this attribute is a
     * 2 dimensional vector.
     *
     * @param size the attribute array size.
     */
    void setSize(int size);

    /**
     * Returns the primitive variable type of the GLSL program attribute.
     *
     * @return the attribute variable type.
     */
    GLAttributeType getType();

    /**
     * Sets the primitive variable type of the GLSL program attribute.
     *
     * @param type the attribute variable type.
     */
    void setType(GLAttributeType type);

    /**
     * Returns if the GLSL program attribute value is normalized.  This specifies whether fixed-point data values should
     * be normalized ({@code true}) or converted directly as fixed-point values ({@code false}) when they are accessed.
     *
     * @return the attribute value normalization.
     */
    boolean isNormalized();

    /**
     * Sets if the GLSL program attribute value is normalized.  This specifies whether fixed-point data values should be
     * normalized ({@code true}) or converted directly as fixed-point values ({@code false}) when they are accessed.
     *
     * @param normalized the attribute value normalization.
     */
    void setNormalized(boolean normalized);

    /**
     * Returns the stride of the GLSL program attribute.  This specifies the byte offset between consecutive generic
     * attribute values.  If the stride is {@code 0}, the attribute is understood to be tightly packed.
     *
     * @return the attribute stride.
     */
    int getStride();

    /**
     * Sets the stride of the GLSL program attribute.  This specifies the byte offset between consecutive generic
     * attribute values.  If the stride is {@code 0}, the attribute is understood to be tightly packed.
     *
     * @param stride the attribute stride.
     */
    void setStride(int stride);

    /**
     * Returns the offset of the GLSL program attribute.  This specifies a pointer to the first component of the first
     * attribute.
     *
     * @return the attribute offset.
     */
    int getOffset();

    /**
     * Returns the offset of the GLSL program attribute.  This specifies a pointer to the first component of the first
     * attribute.
     *
     * @param offset the attribute offset.
     */
    void setOffset(int offset);
}
