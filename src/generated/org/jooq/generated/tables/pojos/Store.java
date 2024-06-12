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
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    private UInteger storeId;
    private UInteger managerStaffId;
    private UInteger addressId;
    private LocalDateTime lastUpdate;

    public Store() {}

    public Store(Store value) {
        this.storeId = value.storeId;
        this.managerStaffId = value.managerStaffId;
        this.addressId = value.addressId;
        this.lastUpdate = value.lastUpdate;
    }

    public Store(
        UInteger storeId,
        UInteger managerStaffId,
        UInteger addressId,
        LocalDateTime lastUpdate
    ) {
        this.storeId = storeId;
        this.managerStaffId = managerStaffId;
        this.addressId = addressId;
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for <code>sakila.store.store_id</code>.
     */
    public UInteger getStoreId() {
        return this.storeId;
    }

    /**
     * Setter for <code>sakila.store.store_id</code>.
     */
    public Store setStoreId(UInteger storeId) {
        this.storeId = storeId;
        return this;
    }

    /**
     * Getter for <code>sakila.store.manager_staff_id</code>.
     */
    public UInteger getManagerStaffId() {
        return this.managerStaffId;
    }

    /**
     * Setter for <code>sakila.store.manager_staff_id</code>.
     */
    public Store setManagerStaffId(UInteger managerStaffId) {
        this.managerStaffId = managerStaffId;
        return this;
    }

    /**
     * Getter for <code>sakila.store.address_id</code>.
     */
    public UInteger getAddressId() {
        return this.addressId;
    }

    /**
     * Setter for <code>sakila.store.address_id</code>.
     */
    public Store setAddressId(UInteger addressId) {
        this.addressId = addressId;
        return this;
    }

    /**
     * Getter for <code>sakila.store.last_update</code>.
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * Setter for <code>sakila.store.last_update</code>.
     */
    public Store setLastUpdate(LocalDateTime lastUpdate) {
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
        final Store other = (Store) obj;
        if (this.storeId == null) {
            if (other.storeId != null)
                return false;
        }
        else if (!this.storeId.equals(other.storeId))
            return false;
        if (this.managerStaffId == null) {
            if (other.managerStaffId != null)
                return false;
        }
        else if (!this.managerStaffId.equals(other.managerStaffId))
            return false;
        if (this.addressId == null) {
            if (other.addressId != null)
                return false;
        }
        else if (!this.addressId.equals(other.addressId))
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
        result = prime * result + ((this.storeId == null) ? 0 : this.storeId.hashCode());
        result = prime * result + ((this.managerStaffId == null) ? 0 : this.managerStaffId.hashCode());
        result = prime * result + ((this.addressId == null) ? 0 : this.addressId.hashCode());
        result = prime * result + ((this.lastUpdate == null) ? 0 : this.lastUpdate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Store (");

        sb.append(storeId);
        sb.append(", ").append(managerStaffId);
        sb.append(", ").append(addressId);
        sb.append(", ").append(lastUpdate);

        sb.append(")");
        return sb.toString();
    }
}
