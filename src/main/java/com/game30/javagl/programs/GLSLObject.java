package com.game30.javagl.programs;

import com.game30.javagl.GLDeletable;
import com.game30.javagl.GLIndexed;

/**
 * An object in the OpenGL API that encapsulates the compiled or linked programs that execute portions of the OpenGL
 * pipeline.  These objects represent code written in the OpenGL Shading Language (GLSL).  Though they are called
 * "objects," they do not fit within the OpenGL object paradigm.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @see <a href="http://www.opengl.org/wiki/GLSL_Object">GLSL Object</a> on the OpenGL wiki
 * @since 1.0.0
 */
public interface GLSLObject extends GLIndexed, GLDeletable {
    /* Implementation Details:
     *     This interface should contain functionality that is core to all GLSL objects.  Anything that is considered
     *     a GLSL object in OpenGL should inherit from this interface.
     */

    // Combined implementation of GLIndexed, GLDeletable
}
