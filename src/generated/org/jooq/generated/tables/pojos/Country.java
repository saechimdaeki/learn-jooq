/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long countryId;
    private String country;
    private LocalDateTime lastUpdate;

    public Country() {}

    public Country(Country value) {
        this.countryId = value.countryId;
        this.country = value.country;
        this.lastUpdate = value.lastUpdate;
    }

    public Country(
        Long countryId,
        String country,
        LocalDateTime lastUpdate
    ) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for <code>sakila.country.country_id</code>.
     */
    public Long getCountryId() {
        return this.countryId;
    }

    /**
     * Setter for <code>sakila.country.country_id</code>.
     */
    public Country setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    /**
     * Getter for <code>sakila.country.country</code>.
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Setter for <code>sakila.country.country</code>.
     */
    public Country setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Getter for <code>sakila.country.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * Setter for <code>sakila.country.last_update</code>.
     */
    public Country setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Country other = (Country) obj;
        if (this.countryId == null) {
            if (other.countryId != null)
                return false;
        }
        else if (!this.countryId.equals(other.countryId))
            return false;
        if (this.country == null) {
            if (other.country != null)
                return false;
        }
        else if (!this.country.equals(other.country))
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
        result = prime * result + ((this.countryId == null) ? 0 : this.countryId.hashCode());
        result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
        result = prime * result + ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Country (");

        sb.append(countryId);
        sb.append(", ").append(country);
        sb.append(", ").append(lastUpdate);

        sb.append(")");
        return sb.toString();
    }
}
