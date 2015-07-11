package com.game30.javagl.programs;

import org.lwjgl.opengl.GL20;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for {@link GLShader}s.  This provides basic source and stage behavior.
 *
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLShaderBase extends GLSLObjectBase implements GLShader {

    /** The class logger. */
    private static final Logger log = LoggerFactory.getLogger(GLShaderBase.class);

    /** The shader pipeline stage. */
    private final GLShaderStage stage;

    /** The shader source code. */
    private String source;

    /**
     * Constructs a GLShaderBase instance with the specified stage.
     *
     * @param stage the shader pipeline stage.
     */
    protected GLShaderBase(GLShaderStage stage) {
        super(GL20.glCreateShader(stage.glInt()));
        this.stage = stage;
    }

    @Override
    public GLShaderStage getStage() {
        return stage;
    }

    @Override
    public void setSource(CharSequence source) {
        GLShader.super.setSource(source);
        this.source = source.toString();
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void compile() {
        GLShader.super.compile();
        if (!getCompileStatus()) {
            log.error("Could not compile [{}] shader [{}].", stage, this);
            log.error(getInfoLog());
            throw new GLShaderException("Could not compile [" + stage + "] shader [" + this + "]");
        }
    }

    @Override
    public void delete() {
        GLShader.super.delete();
        super.delete();
    }
}
