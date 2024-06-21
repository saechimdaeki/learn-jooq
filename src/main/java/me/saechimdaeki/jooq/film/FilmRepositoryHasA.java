package me.saechimdaeki.jooq.film;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.generated.tables.JActor;
import org.jooq.generated.tables.JFilm;
import org.jooq.generated.tables.JFilmActor;
import org.jooq.generated.tables.daos.FilmDao;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

@Repository
public class FilmRepositoryHasA {
    private final FilmDao filmDao;
    private final DSLContext dslContext;
    private final JFilm FILM = JFilm.FILM;

    public FilmRepositoryHasA(Configuration configuration, DSLContext dslContext) {
        this.filmDao = new FilmDao(configuration);
        this.dslContext = dslContext;
    }

    public Film findById(Long id) {
        return filmDao.fetchOneByJFilmId(id);
    }

    public List<Film> fetchRangeOfLength(Integer start, Integer end) {
        return filmDao.fetchRangeOfJLength(start, end);
    }

    public SimpleFilmInfo findByIdAsSimpleFilmInfo(Long id) {
        return dslContext.select(FILM.FILM_ID, FILM.TITLE, FILM.DESCRIPTION)
                         .from(FILM)
                         .where(FILM.FILM_ID.eq(id))
                         .fetchOneInto(SimpleFilmInfo.class);
    }

    public List<FilmWithActor> findFilmWithActorsList(Long page, Long pageSize) {
        final JFilmActor FILM_ACTOR = JFilmActor.FILM_ACTOR;
        final JActor ACTOR = JActor.ACTOR;
        return dslContext.select(
                                 DSL.row(FILM.fields()),
                                 DSL.row(FILM_ACTOR.fields()),
                                 DSL.row(ACTOR.fields())
                         )
                         .from(FILM)
                         .join(FILM_ACTOR)
                         .on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
                         .join(ACTOR)
                         .on(FILM_ACTOR.ACTOR_ID.eq(ACTOR.ACTOR_ID))
                         .limit(pageSize)
                         .offset((page - 1) * pageSize)
                         .fetchInto(FilmWithActor.class);
    }
}
