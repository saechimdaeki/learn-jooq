package me.saechimdaeki.jooq.config.converter;

import org.jooq.impl.EnumConverter;

import me.saechimdaeki.jooq.film.FilmPriceSummary;
import me.saechimdaeki.jooq.film.FilmPriceSummary.PriceCategory;

public class PriceCategoryConverter extends EnumConverter<String, PriceCategory> {

    public PriceCategoryConverter() {
        super(String.class, FilmPriceSummary.PriceCategory.class, FilmPriceSummary.PriceCategory::getCode);
    }
}
