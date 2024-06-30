package me.saechimdaeki.jooq.film;

import java.math.BigDecimal;

import lombok.Setter;

@Setter
public class FilmRentalSummary {
    private Long filmId;
    private String title;
    private BigDecimal averageRentalDuration;
}
