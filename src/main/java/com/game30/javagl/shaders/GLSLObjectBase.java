package com.game30.javagl.shaders;

import com.game30.javagl.GLIndexed;

/**
 * Base class for {@link GLSLObject}s.  This provides basic indexed behavior and memory leak protection.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public class GLSLObjectBase implements GLSLObject {

    /** The index of the GLSLObject. */
    private int index;

    /** If the GLSLObject exists. */
    private boolean exists;

    /**
     * Constructs a GLSLObjectBase instance with the specified index.
     *
     * @param index index of the GLSLObject.
     */
    protected GLSLObjectBase(int index) {
        this.index = index;
        this.exists = (index != GLIndexed.NULL_INDEX);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public void delete() {
        exists = false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[index=" + getIndex() + "]";
    }

    @Override
    protected void finalize() throws Throwable {
        // ===== Protection from memory leaks ==== //
        /* If the JVM is deleting this object and it still exists in OpenGL, this could cause a memory leak.  Delete the
         * object in OpenGL and log a warning message.
         */
        if (exists()) {
            System.err.println("GLSLObjectBase::finalize [" + this + "] - Deleted by garbage collection.");
            delete();
        }
        super.finalize();
    }
}
