package me.saechimdaeki.jooq.film;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.generated.tables.JActor;
import org.jooq.generated.tables.JFilm;
import org.jooq.generated.tables.JFilmActor;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FilmRepository {

    private final DSLContext dslContext;
    private final JFilm FILM = JFilm.FILM;

    public Film findById(Long id) {
        return dslContext.select(FILM.fields())
                         .from(FILM)
                         .where(FILM.FILM_ID.eq(id))
                         .fetchOneInto(Film.class);
    }

    public SimpleFilmInfo findSimpleFilmInfoById(Long id) {
        return dslContext.select(FILM.FILM_ID, FILM.TITLE, FILM.DESCRIPTION)
                         .from(FILM)
                         .where(FILM.FILM_ID.eq(id))
                         .fetchOneInto(SimpleFilmInfo.class);
    }

    public List<FilmWithActor> findFilmWithActorList(Long page, Long pageSize) {
        final JFilmActor FILM_ACTOR = JFilmActor.FILM_ACTOR;
        final JActor ACTOR = JActor.ACTOR;

        return dslContext.select(
                                 DSL.row(FILM.fields()),
                                 DSL.row(FILM_ACTOR.fields()),
                                 DSL.row(ACTOR.fields())
                         ).from(FILM)
                         .join(FILM_ACTOR).on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
                         .join(ACTOR).on(FILM_ACTOR.ACTOR_ID.eq(ACTOR.ACTOR_ID))
                         .offset((page - 1) * pageSize)
                         .limit(pageSize)
                         .fetchInto(FilmWithActor.class);
    }
}
