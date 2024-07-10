package jooq.custom.generator;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

public class JPrefixGeneratorStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        return mode == Mode.DEFAULT ? 'J' + super.getJavaClassName(definition, mode) : super.getJavaClassName(definition, mode);
    }
}
