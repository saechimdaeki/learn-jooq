package me.saechimdaeki.jooq.actor;

import lombok.Getter;
import org.jooq.generated.tables.pojos.Actor;
import org.jooq.generated.tables.pojos.Film;

import java.util.List;

@Getter
public record ActorFilmography(Actor actor, List<Film> filmList) {
}
