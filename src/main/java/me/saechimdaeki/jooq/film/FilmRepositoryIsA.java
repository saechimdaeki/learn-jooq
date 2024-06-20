package me.saechimdaeki.jooq.film;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.generated.tables.JFilm;
import org.jooq.generated.tables.daos.FilmDao;
import org.springframework.stereotype.Repository;


@Repository
public class FilmRepositoryIsA extends FilmDao {
    private final DSLContext dslContext;
    private final JFilm FILM = JFilm.FILM;

    public FilmRepositoryIsA(Configuration configuration, DSLContext dslContext) {
        super(configuration);
        this.dslContext = dslContext;
    }
}
