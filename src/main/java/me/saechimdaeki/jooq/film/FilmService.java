package me.saechimdaeki.jooq.film;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.saechimdaeki.jooq.web.FilmWIthActorPageResponse;
import me.saechimdaeki.jooq.web.PageResponse;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmWIthActorPageResponse getFilmActorPageResponse(Long page, Long pageSize) {
        final List<FilmWithActor> filmWithActorList = filmRepository.findFilmWithActorList(page, pageSize);
        final PageResponse pageResponse = new PageResponse(page, pageSize);

        return new FilmWIthActorPageResponse(pageResponse, filmWithActorList);
    }
}
