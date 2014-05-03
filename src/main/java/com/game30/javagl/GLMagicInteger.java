package com.game30.javagl;

/**
 * A simple interface represents a OpenGL magic integer.  Magic integers are the integer values that represent something
 * unique.  Usually these are encapsulated within a static integer but the binding is still weak.  This interface allows
 * an enumeration to define the valid options and still supply the lower level integer to OpenGL.
 *
 * @author Brian Norman
 * @since 1.0
 */
public interface GLMagicInteger {

    /**
     * Returns the magic integer that OpenGL understands.
     *
     * @return the magic integer.
     */
    int glInt();
}
