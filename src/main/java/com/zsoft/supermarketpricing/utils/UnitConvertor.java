package com.zsoft.supermarketpricing.utils;

import com.zsoft.supermarketpricing.exceptions.ConversionException;
import com.zsoft.supermarketpricing.models.enums.Unit;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UnitConvertor implements BiFunction<Unit, Unit, Float> {


    @Override
    public Float apply(Unit inputUnit, Unit outputUnit) {
        if (inputUnit == null) {
            throw new NullPointerException("input unit is null");
        }
        if (outputUnit == null) {
            throw new NullPointerException("output unit is null.");
        }
        if (outputUnit == inputUnit) {
            return 1F;
        }

        switch (inputUnit) {
            case OUNCE:
                return 1 / 16F;
            case POUND:
                return 16F;
            default:
                try {
                    throw new ConversionException();
                } catch (ConversionException e) {
                    e.printStackTrace();
                }
        }
        return 1F;
    }
}