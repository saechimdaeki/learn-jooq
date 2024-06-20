package me.saechimdaeki.jooq.film;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;

import org.jooq.generated.tables.pojos.Film;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilmRepositoryHasATest {

    @Autowired
    FilmRepositoryIsA filmRepositoryIsA;

    @Autowired
    FilmRepositoryHasA filmRepositoryHasA;

    @Test
    @DisplayName(""" 
            상속) 자동생성 DAO 사용
               - 영화 길이가 100 ~ 180 분 사이인 영화 조회
            """)
    void 상속_DAO_1() {
        // given
        final var start = 100;
        final var end = 180;

        // when
        final List<Film> films = filmRepositoryIsA.fetchRangeOfJLength(start, end);

        // then
        assertThat(films).allSatisfy(film -> assertThat(film.getLength()).isBetween(start, end)
        );
    }

}
