package me.saechimdaeki.jooq.film;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.generated.tables.JFilm;
import org.jooq.generated.tables.daos.FilmDao;
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
}
