package me.saechimdaeki.jooq.web;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.saechimdaeki.jooq.film.FilmWithActor;

@Getter
public class FilmWIthActorPageResponse {
    private PageResponse page;
    private List<FilmActorResponse> filmActorList;

    public FilmWIthActorPageResponse(PageResponse page, List<FilmWithActor> filmWithActors) {
        this.page = page;
        this.filmActorList = filmWithActors.stream()
                                           .map(FilmActorResponse::new)
                                           .toList();
    }

    @Getter
    public static class FilmActorResponse {
        private final String filmTitle;
        private final String actorFullName;
        private final Long field;

        public FilmActorResponse(FilmWithActor filmWithActor) {
            this.filmTitle = filmWithActor.getTitle();
            this.actorFullName = filmWithActor.getActorFullName();
            this.field = filmWithActor.getFilmId();
        }
    }
}
