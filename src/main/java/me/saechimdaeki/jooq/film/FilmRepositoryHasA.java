package me.saechimdaeki.jooq.film;

import static org.jooq.impl.DSL.*;

import java.math.BigDecimal;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.DatePart;
import org.jooq.generated.tables.JActor;
import org.jooq.generated.tables.JFilm;
import org.jooq.generated.tables.JFilmActor;
import org.jooq.generated.tables.JInventory;
import org.jooq.generated.tables.JRental;
import org.jooq.generated.tables.daos.FilmDao;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import me.saechimdaeki.jooq.config.converter.PriceCategoryConverter;

@Repository
public class FilmRepositoryHasA {
    private final FilmDao filmDao;
    private final DSLContext dslContext;
    private final JFilm FILM = JFilm.FILM;

    public FilmRepositoryHasA(Configuration configuration, DSLContext dslContext) {
        filmDao = new FilmDao(configuration);
        this.dslContext = dslContext;
    }

    public Film findById(Long id) {
        return filmDao.fetchOneByJFilmId(id);
    }

    public List<Film> fetchRangeOfLength(Integer start, Integer end) {
        return filmDao.fetchRangeOfJLength(start, end);
    }

    public SimpleFilmInfo findByIdAsSimpleFilmInfo(Long id) {
        return dslContext.select(FILM.FILM_ID, FILM.TITLE, FILM.DESCRIPTION)
                         .from(FILM)
                         .where(FILM.FILM_ID.eq(id))
                         .fetchOneInto(SimpleFilmInfo.class);
    }

    public List<FilmWithActor> findFilmWithActorsList(Long page, Long pageSize) {
        final JFilmActor FILM_ACTOR = JFilmActor.FILM_ACTOR;
        final JActor ACTOR = JActor.ACTOR;
        return dslContext.select(
                                 row(FILM.fields()),
                                 row(FILM_ACTOR.fields()),
                                 row(ACTOR.fields())
                         )
                         .from(FILM)
                         .join(FILM_ACTOR)
                         .on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
                         .join(ACTOR)
                         .on(FILM_ACTOR.ACTOR_ID.eq(ACTOR.ACTOR_ID))
                         .limit(pageSize)
                         .offset((page - 1) * pageSize)
                         .fetchInto(FilmWithActor.class);
    }

    public List<FilmPriceSummary> findFilmPirceSummaryByFilmTitle(String filmTitle) {
        final JInventory INVENTORY = JInventory.INVENTORY;
        return dslContext.select(
                                 FILM.FILM_ID,
                                 FILM.TITLE,
                                 FILM.RENTAL_RATE,
                                 case_().when(FILM.RENTAL_RATE.le(BigDecimal.valueOf(1.0)), "Cheap")
                                        .when(FILM.RENTAL_RATE.le(BigDecimal.valueOf(3.0)), "Moderate")
                                        .else_("Expensive").as("price_category").convert(new PriceCategoryConverter()),
                                 selectCount().from(INVENTORY).where(INVENTORY.FILM_ID.eq(FILM.FILM_ID)).asField("total_inventory")
                         ).from(FILM)
                         .where(FILM.TITLE.like('%' + filmTitle + '%'))
                         .fetchInto(FilmPriceSummary.class);
    }

    public List<FilmRentalSummary> findFilmRentalSummaryByFilmTitle(String filmTitle) {
        final JInventory INVENTORY = JInventory.INVENTORY;
        final JRental RENTAL = JRental.RENTAL;

        final var rentalDurationInfoSubquery = select(
                INVENTORY.FILM_ID,
                avg(localDateTimeDiff(DatePart.DAY, RENTAL.RENTAL_DATE, RENTAL.RETURN_DATE)).as("average_rental_duration")
        ).from(RENTAL)
         .join(INVENTORY)
         .on(RENTAL.INVENTORY_ID.eq(INVENTORY.INVENTORY_ID))
         .where(RENTAL.RETURN_DATE.isNotNull())
         .groupBy(INVENTORY.FILM_ID)
         .asTable("rental_duration_info");

        return dslContext.select(
                                 FILM.FILM_ID,
                                 FILM.TITLE,
                                 rentalDurationInfoSubquery.field("average_rental_duration")
                         ).from(FILM)
                         .join(rentalDurationInfoSubquery)
                         .on(FILM.FILM_ID.eq(rentalDurationInfoSubquery.field(INVENTORY.FILM_ID)))
                         .where(FILM.TITLE.like('%' + filmTitle + '%'))
                         .orderBy(field(name("average_rental_duration")).desc())
                         .fetchInto(FilmRentalSummary.class);
    }

    public List<Film> findRentalFilmByTitle(String filmTitle) {
        final JInventory INVENTORY = JInventory.INVENTORY;
        final JRental RENTAL = JRental.RENTAL;

        return dslContext.selectFrom(FILM)
                         .whereExists(
                                 selectOne().from(INVENTORY)
                                            .join(RENTAL)
                                            .on(RENTAL.INVENTORY_ID.eq(INVENTORY.INVENTORY_ID))
                                            .where(INVENTORY.FILM_ID.eq(FILM.FILM_ID))
                         ).and(FILM.TITLE.like('%' + filmTitle + '%'))
                         .fetchInto(Film.class);
    }
}
