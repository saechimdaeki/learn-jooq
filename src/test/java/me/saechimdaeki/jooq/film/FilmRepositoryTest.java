package me.saechimdaeki.jooq.film;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.jooq.generated.tables.pojos.Film;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilmRepositoryTest {

    @Autowired
    FilmRepository filmRepository;

    @Test
    @DisplayName("1) 영화 정보 조회")
    void findById() {
        // given
        final Long id = 1L;

        // when
        final Film film = filmRepository.findById(id);

        // then
        Assertions.assertThat(film).isNotNull();
    }
}
