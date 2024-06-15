/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.time.LocalDateTime;
import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.JSakila;
import org.jooq.generated.Keys;
import org.jooq.generated.tables.JCity.CityPath;
import org.jooq.generated.tables.records.CountryRecord;
import org.jooq.impl.AutoConverter;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JCountry extends TableImpl<CountryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sakila.country</code>
     */
    public static final JCountry COUNTRY = new JCountry();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CountryRecord> getRecordType() {
        return CountryRecord.class;
    }

    /**
     * The column <code>sakila.country.country_id</code>.
     */
    public final TableField<CountryRecord, Long> COUNTRY_ID = createField(DSL.name("country_id"), SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "", new AutoConverter<UInteger, Long>(UInteger.class, Long.class));

    /**
     * The column <code>sakila.country.country</code>.
     */
    public final TableField<CountryRecord, String> COUNTRY_ = createField(DSL.name("country"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>sakila.country.last_update</code>.
     */
    public final TableField<CountryRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private JCountry(Name alias, Table<CountryRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private JCountry(Name alias, Table<CountryRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>sakila.country</code> table reference
     */
    public JCountry(String alias) {
        this(DSL.name(alias), COUNTRY);
    }

    /**
     * Create an aliased <code>sakila.country</code> table reference
     */
    public JCountry(Name alias) {
        this(alias, COUNTRY);
    }

    /**
     * Create a <code>sakila.country</code> table reference
     */
    public JCountry() {
        this(DSL.name("country"), null);
    }

    public <O extends Record> JCountry(Table<O> path, ForeignKey<O, CountryRecord> childPath, InverseForeignKey<O, CountryRecord> parentPath) {
        super(path, childPath, parentPath, COUNTRY);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class CountryPath extends JCountry implements Path<CountryRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> CountryPath(Table<O> path, ForeignKey<O, CountryRecord> childPath, InverseForeignKey<O, CountryRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private CountryPath(Name alias, Table<CountryRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public CountryPath as(String alias) {
            return new CountryPath(DSL.name(alias), this);
        }

        @Override
        public CountryPath as(Name alias) {
            return new CountryPath(alias, this);
        }

        @Override
        public CountryPath as(Table<?> alias) {
            return new CountryPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JSakila.SAKILA;
    }

    @Override
    public Identity<CountryRecord, Long> getIdentity() {
        return (Identity<CountryRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CountryRecord> getPrimaryKey() {
        return Keys.KEY_COUNTRY_PRIMARY;
    }

    private transient CityPath _city;

    /**
     * Get the implicit to-many join path to the <code>sakila.city</code> table
     */
    public CityPath city() {
        if (_city == null)
            _city = new CityPath(this, null, Keys.FK_CITY_COUNTRY.getInverseKey());

        return _city;
    }

    @Override
    public JCountry as(String alias) {
        return new JCountry(DSL.name(alias), this);
    }

    @Override
    public JCountry as(Name alias) {
        return new JCountry(alias, this);
    }

    @Override
    public JCountry as(Table<?> alias) {
        return new JCountry(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JCountry rename(String name) {
        return new JCountry(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCountry rename(Name name) {
        return new JCountry(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCountry rename(Table<?> name) {
        return new JCountry(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JCountry where(Condition condition) {
        return new JCountry(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JCountry where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JCountry where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JCountry where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JCountry where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JCountry where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JCountry where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JCountry where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JCountry whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JCountry whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
