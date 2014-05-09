package com.game30.javagl.buffers;

/**
 * An enumeration of how frequently a OpenGL buffer can be written.  Frequency is very ambiguous and should be treated
 * as such.  Performance on different hardware and software should be evaluated before choosing a specific frequency.
 *
 * @author Brian Norman
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0
 */
public enum GLBufferUsageFrequency {

    /**
     * A static buffer is a buffer that is usually written to once and never changed.  This is only a guideline though,
     * because there is no restriction to changing a static buffer.
     */
    Static,

    /**
     * A dynamic buffer is a buffer that is written to often.  This is the most ambiguous of all frequencies because it
     * is the middle ground between static and stream.  Usually if a buffer does not fall into either the static or
     * stream category, it should be a dynamic buffer.
     */
    Dynamic,

    /**
     * A stream buffer is a buffer that is usually written to just as much as it is read from.  This is only a guideline
     * though, because there is no restriction to never writing to a stream again after the initial write.
     */
    Stream,

    // End of enumeration
    ;
}
