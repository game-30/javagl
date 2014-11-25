package com.game30.javagl.programs;

import java.util.Set;

/**
 * @author Brian Norman
 * @since 1.0.0
 */
public interface GLProgramFactory {

    static GLProgramFactory getDefault() {
        return GLProgramBase::new;
    }


    GLProgram create(GLAttributeFactory attributeFactory, GLUniformFactory uniformFactory);


    default GLProgram create() {
        return create(GLAttributeFactory.getDefault(), GLUniformFactory.getDefault());
    }

    default GLProgram create(GLAttributeFactory attributeFactory, GLUniformFactory uniformFactory,
                             Set<GLShader> shaders) {
        final GLProgram program = create(attributeFactory, uniformFactory);
        shaders.forEach(program::attach);
        return program;
    }

    default GLProgram create(Set<GLShader> shaders) {
        final GLProgramBase program = new GLProgramBase(GLAttributeFactory.getDefault(), GLUniformFactory.getDefault());
        shaders.forEach(program::attach);
        return program;
    }
}
