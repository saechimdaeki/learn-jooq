/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records;


import java.math.BigDecimal;

import org.jooq.generated.enums.NicerButSlowerFilmListRating;
import org.jooq.generated.tables.NicerButSlowerFilmList;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.UInteger;
import org.jooq.types.UShort;


/**
 * VIEW
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NicerButSlowerFilmListRecord extends TableRecordImpl<NicerButSlowerFilmListRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.FID</code>.
     */
    public NicerButSlowerFilmListRecord setFid(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.FID</code>.
     */
    public UInteger getFid() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.title</code>.
     */
    public NicerButSlowerFilmListRecord setTitle(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.description</code>.
     */
    public NicerButSlowerFilmListRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.category</code>.
     */
    public NicerButSlowerFilmListRecord setCategory(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.category</code>.
     */
    public String getCategory() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.price</code>.
     */
    public NicerButSlowerFilmListRecord setPrice(BigDecimal value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.length</code>.
     */
    public NicerButSlowerFilmListRecord setLength(UShort value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.length</code>.
     */
    public UShort getLength() {
        return (UShort) get(5);
    }

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.rating</code>.
     */
    public NicerButSlowerFilmListRecord setRating(NicerButSlowerFilmListRating value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.rating</code>.
     */
    public NicerButSlowerFilmListRating getRating() {
        return (NicerButSlowerFilmListRating) get(6);
    }

    /**
     * Setter for <code>sakila.nicer_but_slower_film_list.actors</code>.
     */
    public NicerButSlowerFilmListRecord setActors(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>sakila.nicer_but_slower_film_list.actors</code>.
     */
    public String getActors() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NicerButSlowerFilmListRecord
     */
    public NicerButSlowerFilmListRecord() {
        super(NicerButSlowerFilmList.NICER_BUT_SLOWER_FILM_LIST);
    }

    /**
     * Create a detached, initialised NicerButSlowerFilmListRecord
     */
    public NicerButSlowerFilmListRecord(UInteger fid, String title, String description, String category, BigDecimal price, UShort length, NicerButSlowerFilmListRating rating, String actors) {
        super(NicerButSlowerFilmList.NICER_BUT_SLOWER_FILM_LIST);

        setFid(fid);
        setTitle(title);
        setDescription(description);
        setCategory(category);
        setPrice(price);
        setLength(length);
        setRating(rating);
        setActors(actors);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised NicerButSlowerFilmListRecord
     */
    public NicerButSlowerFilmListRecord(org.jooq.generated.tables.pojos.NicerButSlowerFilmList value) {
        super(NicerButSlowerFilmList.NICER_BUT_SLOWER_FILM_LIST);

        if (value != null) {
            setFid(value.getFid());
            setTitle(value.getTitle());
            setDescription(value.getDescription());
            setCategory(value.getCategory());
            setPrice(value.getPrice());
            setLength(value.getLength());
            setRating(value.getRating());
            setActors(value.getActors());
            resetChangedOnNotNull();
        }
    }
}
