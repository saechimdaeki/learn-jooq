package me.saechimdaeki.jooq.film;

import org.jooq.generated.tables.pojos.Actor;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.generated.tables.pojos.FilmActor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FilmWithActor {
    private final Film film;
    private final FilmActor filmActor;
    private final Actor actor;

    public String getTitle() {
        return film.getTitle();
    }

    public String getActorFullName() {
        return actor.getFirstName() + ' ' + actor.getLastName();
    }

    public Long getFilmId() {
        return film.getFilmId();
    }
}
