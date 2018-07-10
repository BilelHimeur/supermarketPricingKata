package com.zsoft.supermarketpricing.models;


import com.zsoft.supermarketpricing.models.enums.Unit;

import javax.persistence.Embeddable;

@Embeddable
public class Price {
    private double value;
    private Unit unit;

    public Price(double value, Unit unit) {

        this.value = value;
        this.unit = unit;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (Double.compare(price.value, value) != 0) return false;
        return unit == price.unit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}