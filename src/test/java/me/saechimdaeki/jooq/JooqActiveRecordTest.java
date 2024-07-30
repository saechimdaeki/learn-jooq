package me.saechimdaeki.jooq;

import org.assertj.core.api.Assertions;
import org.jooq.DSLContext;
import org.jooq.generated.tables.JActor;
import org.jooq.generated.tables.records.ActorRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.saechimdaeki.jooq.actor.ActorRepository;

@SpringBootTest
class JooqActiveRecordTest {

    @Autowired
    DSLContext dslContext;

    @Autowired
    ActorRepository actorRepository;


    @Test
    @DisplayName("SELECT 절 예제")
    void activeRecord_조회_예제() {
        // given
        Long actorId = 1L;
        // when
        ActorRecord actorRecord = actorRepository.findRecordByActorId(actorId);

        // then
        Assertions.assertThat(actorRecord).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("activeRecord refresh 예제")
    void activeRecord_refresh_예제() {
        // given
        Long actorId = 1L;
        ActorRecord actorRecord = actorRepository.findRecordByActorId(actorId);
        actorRecord.setFirstName(null);

        // when
        actorRecord.refresh();

        // then
        Assertions.assertThat(actorRecord.getFirstName()).isNotBlank();
    }

    @Test
    @DisplayName("activeRecord stroe 예제 - insert")
    void activeRecord_insert_예제() {
        // given
        ActorRecord actorRecord = dslContext.newRecord(JActor.ACTOR);

        // when
        actorRecord.setFirstName("john");
        actorRecord.setLastName("doe");
        actorRecord.store();
        actorRecord.refresh();

        // then
        Assertions.assertThat(actorRecord.getLastUpdate()).isNotNull();
    }

    @Test
    @DisplayName("activeRecord stroe 예제 - update")
    void activeRecord_update_예제() {
        // given
        Long actorId = 1L;
        String newName = "test";
        ActorRecord actorRecord = actorRepository.findRecordByActorId(actorId);
        // when

        actorRecord.setFirstName(newName);
        actorRecord.store();

        // then
        Assertions.assertThat(actorRecord.getFirstName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("activeRecord deleted 예제")
    void activeRecord_delete_예제() {
        // given
        ActorRecord actorRecord = dslContext.newRecord(JActor.ACTOR);
        actorRecord.setFirstName("john");
        actorRecord.setLastName("doe");
        actorRecord.store();

        // when
        int result = actorRecord.delete();

        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
}
