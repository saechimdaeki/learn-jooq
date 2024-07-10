package me.saechimdaeki.util.jooq;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;
import org.jooq.tools.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JooqStringConditionUtils {

    public static Condition containsIfNotBlank(Field<String> field, String value) {
        return StringUtils.isBlank(value) ? DSL.noCondition() : field.like('%' + value + '%');
    }

    public static Condition eqIfNotBlank(Field<String> field, String value) {
        return StringUtils.isBlank(value) ? DSL.noCondition() : field.eq(value);
    }
}
