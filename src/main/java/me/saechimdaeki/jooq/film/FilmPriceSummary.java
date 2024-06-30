package me.saechimdaeki.jooq.film;

import java.math.BigDecimal;

import lombok.Setter;

@Setter
public class FilmPriceSummary {
    private Long filmId;
    private String title;
    private BigDecimal rentalRate;
    private String priceCategory;
    private Long totalInventory;
}
