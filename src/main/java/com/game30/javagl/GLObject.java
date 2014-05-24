package com.game30.javagl;

/**
 * An OpenGL construct that contains some state.  They can be bound to the current context and their state is added to
 * the context.  Changes to the current context will effect any bound object's state.  Since OpenGL is a state machine,
 * this is how changes to objects are made.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @see <a href="http://www.opengl.org/wiki/OpenGL_Object">OpenGL Object on OpenGL wiki</a>
 * @since 1.0.0
 */
public interface GLObject extends GLIndexed, GLDeletable, GLBindable {
    /* Implementation Details:
     *     This interface should contain functionality that is core to all OpenGL objects.  Anything that is considered
     *     an object in OpenGL should inherit from this interface.  However, some things have the same functionality as
     *     an OpenGL object but are not considered true OpenGL objects.  This is why certain functionality is broken out
     *     into separate interfaces.
     */

    // Combined implementation of GLIndexed, GLDeletable, and GLBindable
}
