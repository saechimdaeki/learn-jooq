/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FilmActor implements Serializable {

    private static final long serialVersionUID = 1L;

    private final UInteger actorId;
    private final UInteger filmId;
    private final LocalDateTime lastUpdate;

    public FilmActor(FilmActor value) {
        this.actorId = value.actorId;
        this.filmId = value.filmId;
        this.lastUpdate = value.lastUpdate;
    }

    public FilmActor(
        UInteger actorId,
        UInteger filmId,
        LocalDateTime lastUpdate
    ) {
        this.actorId = actorId;
        this.filmId = filmId;
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for <code>sakila.film_actor.actor_id</code>.
     */
    public UInteger getActorId() {
        return this.actorId;
    }

    /**
     * Getter for <code>sakila.film_actor.film_id</code>.
     */
    public UInteger getFilmId() {
        return this.filmId;
    }

    /**
     * Getter for <code>sakila.film_actor.last_update</code>.
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
        final FilmActor other = (FilmActor) obj;
        if (this.actorId == null) {
            if (other.actorId != null)
                return false;
        }
        else if (!this.actorId.equals(other.actorId))
            return false;
        if (this.filmId == null) {
            if (other.filmId != null)
                return false;
        }
        else if (!this.filmId.equals(other.filmId))
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
        result = prime * result + ((this.actorId == null) ? 0 : this.actorId.hashCode());
        result = prime * result + ((this.filmId == null) ? 0 : this.filmId.hashCode());
        result = prime * result + ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FilmActor (");

        sb.append(actorId);
        sb.append(", ").append(filmId);
        sb.append(", ").append(lastUpdate);

        sb.append(")");
        return sb.toString();
    }
}
