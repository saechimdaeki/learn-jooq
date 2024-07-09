package me.saechimdaeki.jooq.actor;

import static me.saechimdaeki.util.jooq.JooqListConditionUtils.inIfNotEmpty;
import static me.saechimdaeki.util.jooq.JooqStringConditionUtils.containsIfNotBlank;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Row2;
import org.jooq.generated.tables.JActor;
import org.jooq.generated.tables.JFilm;
import org.jooq.generated.tables.JFilmActor;
import org.jooq.generated.tables.daos.ActorDao;
import org.jooq.generated.tables.pojos.Actor;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.generated.tables.records.ActorRecord;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ActorRepository {

    private final DSLContext dslContext;
    private final ActorDao actorDao;
    private final JActor ACTOR = JActor.ACTOR;

    public ActorRepository(DSLContext dslContext, Configuration configuration) {
        actorDao = new ActorDao(configuration);
        this.dslContext = dslContext;
    }

    public List<Actor> findByFirstnameAndLastName(String firstName, String lastName) {
        return dslContext.selectFrom(ACTOR)
                         .where(
                                 ACTOR.FIRST_NAME.eq(firstName),
                                 ACTOR.LAST_NAME.eq(lastName)
                         ).fetchInto(Actor.class);
    }

    public List<Actor> findByFirstnameOrLastName(String firstName, String lastName) {
        return dslContext.selectFrom(ACTOR)
                         .where(
                                 ACTOR.FIRST_NAME.eq(firstName).or(ACTOR.LAST_NAME.eq(lastName)),
                                 ACTOR.FIRST_NAME.eq(firstName)
                         ).fetchInto(Actor.class);
    }

    public List<Actor> findByActorIdIn(List<Long> idList) {
        return dslContext.selectFrom(ACTOR)
                         .where(inIfNotEmpty(ACTOR.ACTOR_ID, idList))
                         .fetchInto(Actor.class);
    }

    public List<ActorFilmography> findActorFilmography(ActorFilmographySearchOption searchOption) {
        final JFilmActor FILM_ACTOR = JFilmActor.FILM_ACTOR;
        final JFilm FILM = JFilm.FILM;

        final Map<Actor, List<Film>> actorListMap = dslContext.select(
                                                                      DSL.row(ACTOR.fields()).as("actor"),
                                                                      DSL.row(FILM.fields()).as("film")
                                                              ).from(ACTOR)
                                                              .join(FILM_ACTOR)
                                                              .on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
                                                              .join(FILM)
                                                              .on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
                                                              .where(
                                                                      // 배우 full name like 검색
                                                                      containsIfNotBlank(ACTOR.FIRST_NAME.concat(" ").concat(ACTOR.LAST_NAME), searchOption.getActorName()),

                                                                      // 영화 제목 like 검색
                                                                      containsIfNotBlank(FILM.TITLE, searchOption.getFilmTitle())
                                                              )
                                                              .fetchGroups(
                                                                      record -> record.get("actor", Actor.class),
                                                                      record -> record.get("film", Film.class)
                                                              );

        return actorListMap.entrySet().stream()
                           .map(entry -> new ActorFilmography(entry.getKey(), entry.getValue()))
                           .toList();
    }

    public Actor saveByDao(Actor actor) {
        actorDao.insert(actor);
        return actor;
    }

    public ActorRecord saveByRecord(Actor actor) {
        final ActorRecord actorRecord = dslContext.newRecord(ACTOR, actor);
        actorRecord.insert();
        return actorRecord;
    }

    public Long saveWithReturningPkOnly(Actor actor) {
        return dslContext.insertInto(
                                 ACTOR, ACTOR.FIRST_NAME,
                                 ACTOR.LAST_NAME
                         ).values(
                                 actor.getFirstName(),
                                 actor.getLastName()
                         ).returningResult(ACTOR.ACTOR_ID)
                         .fetchOneInto(Long.class);
    }

    public Actor saveWithReturning(Actor actor) {
        return dslContext.insertInto(
                                 ACTOR,
                                 ACTOR.FIRST_NAME,
                                 ACTOR.LAST_NAME
                         ).values(actor.getFirstName(),
                                  actor.getLastName())
                         .returning(ACTOR.fields())
                         .fetchOneInto(Actor.class);
    }

    public void bulkInsertWithRows(List<Actor> actors) {

        final List<Row2<String, String>> rows = actors.stream()
                                                      .map(actor -> DSL.row(
                                                              actor.getFirstName(),
                                                              actor.getLastName()
                                                      )).toList();
        dslContext.insertInto(
                ACTOR,
                ACTOR.FIRST_NAME,
                ACTOR.LAST_NAME
        ).valuesOfRows(rows).execute();
    }
}
