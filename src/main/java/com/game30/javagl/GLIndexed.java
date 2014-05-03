package com.game30.javagl;

/**
 * Describes an object in OpenGL that is referenced by index.
 *
 * @author Brian Norman
 * @since 1.0
 */
public interface GLIndexed {

    /**
     * Returns the index, also known as the GLuint, of the OpenGL object.  This is the integer returned by the object
     * generation call to OpenGL.
     *
     * @return the index.
     */
    int getIndex();


    // ============================ //
    // ***** Static GLIndexed ***** //
    // ============================ //

    /**
     * Object null index.  This is essentially the NULL pointer for OpenGL.
     */
    int NULL_INDEX = 0;
}
