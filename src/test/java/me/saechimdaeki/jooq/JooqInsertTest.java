package me.saechimdaeki.jooq;

import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.jooq.generated.tables.pojos.Actor;
import org.jooq.generated.tables.records.ActorRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import me.saechimdaeki.jooq.actor.ActorRepository;

@SpringBootTest
class JooqInsertTest {

    @Autowired
    ActorRepository actorRepository;

    @Test
    @DisplayName("자동 생성된 DAO를 통한 insert")
    @Transactional
    void insert_dao() {

        // given
        final Actor actor = new Actor();
        actor.setFirstName("saechim");
        actor.setLastName("daeki");
        actor.setLastUpdate(LocalDateTime.now());

        // when
        actorRepository.saveByDao(actor);

        // then
        Assertions.assertThat(actor.getActorId()).isNotNull();
    }

    @Test
    @DisplayName("ActiveRecord를 통한 insert")
    @Transactional
    void insert_by_record() {
        // given
        final Actor actor = new Actor();
        actor.setFirstName("saechim");
        actor.setLastName("daeki");
        actor.setLastUpdate(LocalDateTime.now());

        // when
        final ActorRecord actorRecord = actorRepository.saveByRecord(actor);
        // then

        Assertions.assertThat(actorRecord.getActorId()).isNotNull();
        Assertions.assertThat(actor.getActorId()).isNull();
    }

    @Test
    @DisplayName("SQL 실행 후 PK만 반환")
    @Transactional
    void insert_with_returning_pk() {
        // given
        final Actor actor = new Actor();
        actor.setFirstName("saechim");
        actor.setLastName("daeki");
        actor.setLastUpdate(LocalDateTime.now());

        // when
        final Long pk = actorRepository.saveWithReturningPkOnly(actor);
        // then
        Assertions.assertThat(pk).isNotNull();
    }

    @Test
    @DisplayName("SQL 실행 후 해당 ROW 반환")
    @Transactional
    void insert_with_returning() {
        // given
        final Actor actor = new Actor();
        actor.setFirstName("saechim");
        actor.setLastName("daeki");
        actor.setLastUpdate(LocalDateTime.now());

        // when
        final Actor newActor = actorRepository.saveWithReturning(actor);

        // then
        Assertions.assertThat(newActor).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("bulk insert 예제")
    @Transactional
    void bulk_insert() {
        // given
        final Actor actor1 = new Actor();
        actor1.setFirstName("saechim");
        actor1.setLastName("daeki");
        actor1.setLastUpdate(LocalDateTime.now());

        final Actor actor2 = new Actor();
        actor2.setFirstName("saechim2");
        actor2.setLastName("daeki2");
        actor2.setLastUpdate(LocalDateTime.now());

        // when
        actorRepository.bulkInsertWithRows(List.of(actor1, actor2));

        // then
    }

}
