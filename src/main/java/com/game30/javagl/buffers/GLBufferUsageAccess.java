package com.game30.javagl.buffers;

/**
 * An enumeration of the different ways a program can interact with an OpenGL buffer.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public enum GLBufferUsageAccess {

    /**
     * A write access buffer is a buffer that the program writes to and OpenGL reads from.  The program cannot read from
     * the buffer nor can OpenGL write to it.  This is used to give information to OpenGL for operations, such as
     * drawing.
     */
    Write,

    /**
     * A read access buffer is a buffer that the program read from and OpenGL write to.  The program cannot write to the
     * buffer nor can OpenGL read from it.  This is used to get information from OpenGL, such as transformations.
     */
    Read,

    /**
     * A none access buffer is a buffer that the program cannot read from or write to but OpenGL is able to both read
     * from and write to.   This is used to transfer information within OpenGL between operations.
     */
    None,

    // End of enumeration
    ;
}
