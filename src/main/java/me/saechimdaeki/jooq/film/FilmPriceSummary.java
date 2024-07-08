package me.saechimdaeki.jooq.film;

import java.math.BigDecimal;
import java.util.Arrays;

import lombok.Getter;

@Getter
public class FilmPriceSummary {

    private Long filmId;
    private String title;
    private PriceCategory priceCategory;
    private BigDecimal rentalRate;
    private Long totalInventory;

    @Getter
    public enum PriceCategory {
        CHEAP("Cheap"),
        MODERATE("Moderate"),
        EXPENSIVE("Expensive");

        private final String code;

        PriceCategory(String code) {
            this.code = code;
        }

        public static PriceCategory findByCode(String code) {
            return Arrays.stream(values()).filter(value -> value.code.equalsIgnoreCase(code)).findFirst().orElse(null);
        }
    }
}
