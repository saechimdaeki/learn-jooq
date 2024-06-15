/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.generated.tables.JFilmActor;
import org.jooq.generated.tables.pojos.FilmActor;
import org.jooq.generated.tables.records.FilmActorRecord;
import org.jooq.impl.AutoConverter;
import org.jooq.impl.DAOImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FilmActorDao extends DAOImpl<FilmActorRecord, FilmActor, Record2<Long, Long>> {

    /**
     * Create a new FilmActorDao without any configuration
     */
    public FilmActorDao() {
        super(JFilmActor.FILM_ACTOR, FilmActor.class);
    }

    /**
     * Create a new FilmActorDao with an attached configuration
     */
    public FilmActorDao(Configuration configuration) {
        super(JFilmActor.FILM_ACTOR, FilmActor.class, configuration);
    }

    @Override
    public Record2<Long, Long> getId(FilmActor object) {
        return compositeKeyRecord(object.getActorId(), object.getFilmId());
    }

    /**
     * Fetch records that have <code>actor_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<FilmActor> fetchRangeOfJActorId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(JFilmActor.FILM_ACTOR.ACTOR_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>actor_id IN (values)</code>
     */
    public List<FilmActor> fetchByJActorId(Long... values) {
        return fetch(JFilmActor.FILM_ACTOR.ACTOR_ID, values);
    }

    /**
     * Fetch records that have <code>film_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<FilmActor> fetchRangeOfJFilmId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(JFilmActor.FILM_ACTOR.FILM_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>film_id IN (values)</code>
     */
    public List<FilmActor> fetchByJFilmId(Long... values) {
        return fetch(JFilmActor.FILM_ACTOR.FILM_ID, values);
    }

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<FilmActor> fetchRangeOfJLastUpdate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JFilmActor.FILM_ACTOR.LAST_UPDATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    public List<FilmActor> fetchByJLastUpdate(LocalDateTime... values) {
        return fetch(JFilmActor.FILM_ACTOR.LAST_UPDATE, values);
    }
}
