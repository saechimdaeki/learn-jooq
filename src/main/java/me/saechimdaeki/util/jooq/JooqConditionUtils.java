package me.saechimdaeki.util.jooq;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;
import org.jooq.tools.StringUtils;

public class JooqConditionUtils {
    public static <T> Condition eq(Field<T> field, T value) {
        if (value == null) {
            return DSL.noCondition();
        }
        return field.eq(value);
    }
}
