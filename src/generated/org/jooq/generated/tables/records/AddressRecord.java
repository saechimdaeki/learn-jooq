/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records;


import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.generated.tables.Address;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressRecord extends UpdatableRecordImpl<AddressRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sakila.address.address_id</code>.
     */
    public AddressRecord setAddressId(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.address_id</code>.
     */
    public UInteger getAddressId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>sakila.address.address</code>.
     */
    public AddressRecord setAddress(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.address</code>.
     */
    public String getAddress() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sakila.address.address2</code>.
     */
    public AddressRecord setAddress2(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.address2</code>.
     */
    public String getAddress2() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sakila.address.district</code>.
     */
    public AddressRecord setDistrict(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.district</code>.
     */
    public String getDistrict() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sakila.address.city_id</code>.
     */
    public AddressRecord setCityId(UInteger value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.city_id</code>.
     */
    public UInteger getCityId() {
        return (UInteger) get(4);
    }

    /**
     * Setter for <code>sakila.address.postal_code</code>.
     */
    public AddressRecord setPostalCode(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.postal_code</code>.
     */
    public String getPostalCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>sakila.address.phone</code>.
     */
    public AddressRecord setPhone(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.phone</code>.
     */
    public String getPhone() {
        return (String) get(6);
    }

    /**
     * Setter for <code>sakila.address.last_update</code>.
     */
    public AddressRecord setLastUpdate(LocalDateTime value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>sakila.address.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return (LocalDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddressRecord
     */
    public AddressRecord() {
        super(Address.ADDRESS);
    }

    /**
     * Create a detached, initialised AddressRecord
     */
    public AddressRecord(UInteger addressId, String address, String address2, String district, UInteger cityId, String postalCode, String phone, LocalDateTime lastUpdate) {
        super(Address.ADDRESS);

        setAddressId(addressId);
        setAddress(address);
        setAddress2(address2);
        setDistrict(district);
        setCityId(cityId);
        setPostalCode(postalCode);
        setPhone(phone);
        setLastUpdate(lastUpdate);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised AddressRecord
     */
    public AddressRecord(org.jooq.generated.tables.pojos.Address value) {
        super(Address.ADDRESS);

        if (value != null) {
            setAddressId(value.getAddressId());
            setAddress(value.getAddress());
            setAddress2(value.getAddress2());
            setDistrict(value.getDistrict());
            setCityId(value.getCityId());
            setPostalCode(value.getPostalCode());
            setPhone(value.getPhone());
            setLastUpdate(value.getLastUpdate());
            resetChangedOnNotNull();
        }
    }
}
