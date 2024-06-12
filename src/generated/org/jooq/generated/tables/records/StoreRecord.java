/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records;


import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.generated.tables.JStore;
import org.jooq.generated.tables.pojos.Store;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StoreRecord extends UpdatableRecordImpl<StoreRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sakila.store.store_id</code>.
     */
    public StoreRecord setStoreId(UInteger value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>sakila.store.store_id</code>.
     */
    public UInteger getStoreId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>sakila.store.manager_staff_id</code>.
     */
    public StoreRecord setManagerStaffId(UInteger value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>sakila.store.manager_staff_id</code>.
     */
    public UInteger getManagerStaffId() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>sakila.store.address_id</code>.
     */
    public StoreRecord setAddressId(UInteger value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>sakila.store.address_id</code>.
     */
    public UInteger getAddressId() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>sakila.store.last_update</code>.
     */
    public StoreRecord setLastUpdate(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>sakila.store.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return (LocalDateTime) get(3);
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
     * Create a detached StoreRecord
     */
    public StoreRecord() {
        super(JStore.STORE);
    }

    /**
     * Create a detached, initialised StoreRecord
     */
    public StoreRecord(UInteger storeId, UInteger managerStaffId, UInteger addressId, LocalDateTime lastUpdate) {
        super(JStore.STORE);

        setStoreId(storeId);
        setManagerStaffId(managerStaffId);
        setAddressId(addressId);
        setLastUpdate(lastUpdate);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised StoreRecord
     */
    public StoreRecord(Store value) {
        super(JStore.STORE);

        if (value != null) {
            setStoreId(value.getStoreId());
            setManagerStaffId(value.getManagerStaffId());
            setAddressId(value.getAddressId());
            setLastUpdate(value.getLastUpdate());
            resetChangedOnNotNull();
        }
    }
}
