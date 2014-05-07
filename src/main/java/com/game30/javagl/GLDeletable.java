package com.game30.javagl;

/**
 * Describes an object in OpenGL that can be deleted.
 *
 * @author Brian Norman
 * @since 1.0
 */
public interface GLDeletable {

    /**
     * Deletes the OpenGL object.  The object does not need to be bound to delete the object but other objects
     * associated with the object will need to be deleted in sequence.
     */
    void delete();

    /**
     * Returns {@code true} if the OpenGL object exists.  This may or may not make the request of OpenGL or just keep
     * the state internally.
     *
     * @return if the OpenGL object exists.
     */
    boolean exists();


    // ============================== //
    // ***** Static GLDeletable ***** //
    // ============================== //

    /**
     * Validates that the GLDeletable still exists.  If it does not exist, a NullPointerException is thrown.
     *
     * @param deletable the OpenGL deletable object that needs to exist.
     * @throws NullPointerException if the OpenGL deletable object does not exist.
     */
    static <T extends GLDeletable> T requireExists(T deletable) {
        if (!deletable.exists()) {
            throw new NullPointerException("OpenGL deletable [" + deletable + "] does not exist!");
        }
        return deletable;
    }
}