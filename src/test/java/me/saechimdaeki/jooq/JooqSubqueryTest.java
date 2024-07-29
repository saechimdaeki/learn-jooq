package me.saechimdaeki.jooq;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.jooq.generated.tables.pojos.Film;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.saechimdaeki.jooq.film.FilmPriceSummary;
import me.saechimdaeki.jooq.film.FilmRentalSummary;
import me.saechimdaeki.jooq.film.FilmRepositoryHasA;

@SpringBootTest
public class JooqSubqueryTest {

    @Autowired
    private FilmRepositoryHasA filmRepository;

    @Test
    @DisplayName("""
            영화별 대여료가 1.0 이하면 'cheap'
             3.0 이하면 'Moderate',
             그 이상이면 'Expensive'로 분류하고,
             각 영화의 총 재고수를 조회한다"
            """)
    void 스칼라_서브쿼리_예제() {

        final String filmTitle = "EGG";
        final List<FilmPriceSummary> priceSummaryList = filmRepository.findFilmPriceSummaryByFilmTitle(filmTitle);

        Assertions.assertThat(priceSummaryList).isNotEmpty();
    }

    @Test
    @DisplayName("평균 대여 기간이 가장 긴 영화부터 정렬해서 조회한다")
    void from절_서브쿼리_인라인뷰_예제() {
        final String filmTitle = "EGG";

        final List<FilmRentalSummary> filmRentalSummaryList = filmRepository.findFilmRentalSummaryByFilmTitle(filmTitle);

        Assertions.assertThat(filmRentalSummaryList).isNotEmpty();
    }

    @Test
    @DisplayName("대여된 기록이 있는 영화가 있는 영화만 조회")
    void 조건절_서브쿼리_예제() {
        final String filmTitle = "EGG";

        final List<Film> filmList = filmRepository.findRentalFilmByTitle(filmTitle);

        Assertions.assertThat(filmList).isNotEmpty();

    }
}
