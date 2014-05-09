package com.game30.javagl;

/**
 * Base class for {@link GLObject}s.  This provides basic indexed behavior and memory leak protection.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public abstract class GLObjectBase implements GLObject {

    /** The index of the GLObject. */
    private int index;

    /**
     * Constructs a GLObjectBase instance with the specified index.
     *
     * @param index index of the GLObject.
     */
    protected GLObjectBase(int index) {
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    protected void finalize() throws Throwable {
        // ===== Protection from memory leaks ==== //
        /* If the JVM is deleting this object and it still exists in OpenGL, this could cause a memory leak.  Delete the
         * object in OpenGL and log a warning message.
         */
        if (exists()) {
            System.err.println("GLObjectBase::finalize [" + this + "] - Deleted by garbage collection.");
            delete();
        }
        super.finalize();
    }
}
