package me.saechimdaeki.jooq;

import static org.junit.jupiter.api.Assertions.*;

import org.jooq.DSLContext;
import org.jooq.generated.tables.JActor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JooqApplicationTest {

    @Autowired
    DSLContext dslContext;

    @Test
    void contextLoads() {
        dslContext.selectFrom(JActor.ACTOR)
                .limit(10)
                .fetch();
    }
}
