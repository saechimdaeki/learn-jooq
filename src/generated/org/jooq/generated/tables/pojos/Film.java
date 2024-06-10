/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;

import org.jooq.generated.enums.FilmRating;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    private final UInteger filmId;
    private final String title;
    private final String description;
    private final Year releaseYear;
    private final UInteger languageId;
    private final UInteger originalLanguageId;
    private final UByte rentalDuration;
    private final BigDecimal rentalRate;
    private final UShort length;
    private final BigDecimal replacementCost;
    private final FilmRating rating;
    private final String specialFeatures;
    private final LocalDateTime lastUpdate;

    public Film(Film value) {
        this.filmId = value.filmId;
        this.title = value.title;
        this.description = value.description;
        this.releaseYear = value.releaseYear;
        this.languageId = value.languageId;
        this.originalLanguageId = value.originalLanguageId;
        this.rentalDuration = value.rentalDuration;
        this.rentalRate = value.rentalRate;
        this.length = value.length;
        this.replacementCost = value.replacementCost;
        this.rating = value.rating;
        this.specialFeatures = value.specialFeatures;
        this.lastUpdate = value.lastUpdate;
    }

    public Film(
        UInteger filmId,
        String title,
        String description,
        Year releaseYear,
        UInteger languageId,
        UInteger originalLanguageId,
        UByte rentalDuration,
        BigDecimal rentalRate,
        UShort length,
        BigDecimal replacementCost,
        FilmRating rating,
        String specialFeatures,
        LocalDateTime lastUpdate
    ) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.originalLanguageId = originalLanguageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for <code>sakila.film.film_id</code>.
     */
    public UInteger getFilmId() {
        return this.filmId;
    }

    /**
     * Getter for <code>sakila.film.title</code>.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for <code>sakila.film.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for <code>sakila.film.release_year</code>.
     */
    public Year getReleaseYear() {
        return this.releaseYear;
    }

    /**
     * Getter for <code>sakila.film.language_id</code>.
     */
    public UInteger getLanguageId() {
        return this.languageId;
    }

    /**
     * Getter for <code>sakila.film.original_language_id</code>.
     */
    public UInteger getOriginalLanguageId() {
        return this.originalLanguageId;
    }

    /**
     * Getter for <code>sakila.film.rental_duration</code>.
     */
    public UByte getRentalDuration() {
        return this.rentalDuration;
    }

    /**
     * Getter for <code>sakila.film.rental_rate</code>.
     */
    public BigDecimal getRentalRate() {
        return this.rentalRate;
    }

    /**
     * Getter for <code>sakila.film.length</code>.
     */
    public UShort getLength() {
        return this.length;
    }

    /**
     * Getter for <code>sakila.film.replacement_cost</code>.
     */
    public BigDecimal getReplacementCost() {
        return this.replacementCost;
    }

    /**
     * Getter for <code>sakila.film.rating</code>.
     */
    public FilmRating getRating() {
        return this.rating;
    }

    /**
     * Getter for <code>sakila.film.special_features</code>.
     */
    public String getSpecialFeatures() {
        return this.specialFeatures;
    }

    /**
     * Getter for <code>sakila.film.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Film other = (Film) obj;
        if (this.filmId == null) {
            if (other.filmId != null)
                return false;
        }
        else if (!this.filmId.equals(other.filmId))
            return false;
        if (this.title == null) {
            if (other.title != null)
                return false;
        }
        else if (!this.title.equals(other.title))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.releaseYear == null) {
            if (other.releaseYear != null)
                return false;
        }
        else if (!this.releaseYear.equals(other.releaseYear))
            return false;
        if (this.languageId == null) {
            if (other.languageId != null)
                return false;
        }
        else if (!this.languageId.equals(other.languageId))
            return false;
        if (this.originalLanguageId == null) {
            if (other.originalLanguageId != null)
                return false;
        }
        else if (!this.originalLanguageId.equals(other.originalLanguageId))
            return false;
        if (this.rentalDuration == null) {
            if (other.rentalDuration != null)
                return false;
        }
        else if (!this.rentalDuration.equals(other.rentalDuration))
            return false;
        if (this.rentalRate == null) {
            if (other.rentalRate != null)
                return false;
        }
        else if (!this.rentalRate.equals(other.rentalRate))
            return false;
        if (this.length == null) {
            if (other.length != null)
                return false;
        }
        else if (!this.length.equals(other.length))
            return false;
        if (this.replacementCost == null) {
            if (other.replacementCost != null)
                return false;
        }
        else if (!this.replacementCost.equals(other.replacementCost))
            return false;
        if (this.rating == null) {
            if (other.rating != null)
                return false;
        }
        else if (!this.rating.equals(other.rating))
            return false;
        if (this.specialFeatures == null) {
            if (other.specialFeatures != null)
                return false;
        }
        else if (!this.specialFeatures.equals(other.specialFeatures))
            return false;
        if (this.lastUpdate == null) {
            if (other.lastUpdate != null)
                return false;
        }
        else if (!this.lastUpdate.equals(other.lastUpdate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.filmId == null) ? 0 : this.filmId.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.releaseYear == null) ? 0 : this.releaseYear.hashCode());
        result = prime * result + ((this.languageId == null) ? 0 : this.languageId.hashCode());
        result = prime * result + ((this.originalLanguageId == null) ? 0 : this.originalLanguageId.hashCode());
        result = prime * result + ((this.rentalDuration == null) ? 0 : this.rentalDuration.hashCode());
        result = prime * result + ((this.rentalRate == null) ? 0 : this.rentalRate.hashCode());
        result = prime * result + ((this.length == null) ? 0 : this.length.hashCode());
        result = prime * result + ((this.replacementCost == null) ? 0 : this.replacementCost.hashCode());
        result = prime * result + ((this.rating == null) ? 0 : this.rating.hashCode());
        result = prime * result + ((this.specialFeatures == null) ? 0 : this.specialFeatures.hashCode());
        result = prime * result + ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Film (");

        sb.append(filmId);
        sb.append(", ").append(title);
        sb.append(", ").append(description);
        sb.append(", ").append(releaseYear);
        sb.append(", ").append(languageId);
        sb.append(", ").append(originalLanguageId);
        sb.append(", ").append(rentalDuration);
        sb.append(", ").append(rentalRate);
        sb.append(", ").append(length);
        sb.append(", ").append(replacementCost);
        sb.append(", ").append(rating);
        sb.append(", ").append(specialFeatures);
        sb.append(", ").append(lastUpdate);

        sb.append(")");
        return sb.toString();
    }
}