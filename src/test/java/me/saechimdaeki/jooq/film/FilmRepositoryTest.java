package me.saechimdaeki.jooq.film;

import static org.assertj.core.api.Assertions.*;


import org.jooq.generated.tables.pojos.Film;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.saechimdaeki.jooq.web.FilmWIthActorPageResponse;

@SpringBootTest
class FilmRepositoryTest {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmService filmService;

    @Test
    @DisplayName("1) 영화 정보 조회")
    void findById() {
        // given
        final Long id = 1L;

        // when
        final Film film = filmRepository.findById(id);

        // then
        assertThat(film).isNotNull();
    }

    @Test
    @DisplayName("2) 영화 정보 간략 조회")
    void findSimpleFilmInfoById() {
        final SimpleFilmInfo simpleFilmInfo = filmRepository.findSimpleFilmInfoById(1L);
        assertThat(simpleFilmInfo).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("3) 영화와 영화에 출연한 배우 정보를 페이징하여 조회")
    void findFilmAndActorInfo() {
        // given when
        final FilmWIthActorPageResponse filmActorPageResponse = filmService.getFilmActorPageResponse(1L, 20L);

        //then
        assertThat(filmActorPageResponse).isNotNull();
        assertThat(filmActorPageResponse.getFilmActorList()).hasSize(20);
    }
}
