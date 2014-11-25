package com.game30.javagl.programs;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL20;

/**
 * @author Brian Norman
 * @since 1.0.0
 */
public class GLProgramBase extends GLSLObjectBase implements GLProgram {

    private final GLAttributeFactory attributeFactory;
    private final GLUniformFactory uniformFactory;

    private final Map<GLShaderStage, GLShader> shaders;
    private final Map<String, GLAttribute> attributes;
    private final Map<String, GLUniform> uniforms;

    protected GLProgramBase(GLAttributeFactory attributeFactory, GLUniformFactory uniformFactory) {
        super(GL20.glCreateProgram());
        this.attributeFactory = attributeFactory;
        this.uniformFactory = uniformFactory;

        this.shaders = new EnumMap<>(GLShaderStage.class);
        this.attributes = new HashMap<>();
        this.uniforms = new HashMap<>();
    }

    @Override
    public void delete() {
        GLProgram.super.delete();
        super.delete();
    }

    @Override
    public void attach(GLShader shader) {
        shaders.put(shader.getStage(), shader);
        GLProgram.super.attach(shader);
    }

    @Override
    public void detach(GLShader shader) {
        shaders.remove(shader.getStage());
        GLProgram.super.detach(shader);
    }

    @Override
    public Collection<GLShader> getShaders() {
        return shaders.values();
    }

    @Override
    public GLAttribute getAttribute(CharSequence name) {
        return attributes.computeIfAbsent(name.toString(), n -> {
            int index = GL20.glGetAttribLocation(getIndex(), n);
            if (index >= 0) {
                return attributeFactory.create(index, n);
            } else {
                throw new GLProgramException("Attribute [" + name + "] does not exist");
            }
        });
    }

    @Override
    public GLUniform getUniform(CharSequence name) {
        return uniforms.computeIfAbsent(name.toString(), n -> {
            int index = GL20.glGetUniformLocation(getIndex(), name);
            if (index >= 0) {
                return uniformFactory.create(index, name);
            } else {
                throw new GLProgramException("Uniform [" + name + "] does not exist");
            }
        });
    }
}
