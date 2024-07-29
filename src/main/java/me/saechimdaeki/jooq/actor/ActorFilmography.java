package me.saechimdaeki.jooq.actor;

import org.jooq.generated.tables.pojos.Actor;
import org.jooq.generated.tables.pojos.Film;

import java.util.List;

public record ActorFilmography(Actor actor, List<Film> filmList) {
}
