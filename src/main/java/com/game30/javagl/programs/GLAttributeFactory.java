package com.game30.javagl.programs;

/**
 * A factory interface for {@link GLAttribute}s.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLAttributeFactory {

    /**
     * Returns the default OpenGL attribute factory.
     *
     * @return default attribute factory.
     */
    static GLAttributeFactory getDefault() {
        return GLAttributeBase::new;
    }


    /**
     * Creates a new OpenGL attribute from the specified parameters.
     *
     * @param index the attribute index.
     * @param name the attribute name.
     * @return a new OpenGL attribute.
     */
    GLAttribute create(int index, CharSequence name);
}
