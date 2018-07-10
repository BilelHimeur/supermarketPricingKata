package com.zsoft.supermarketpricing.utils;

import com.zsoft.supermarketpricing.models.enums.Unit;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UnitConvertor implements BiFunction<Unit, Unit, Float> {


    @Override
    public Float apply(Unit inputUnit, Unit outputUnit) {
        return 0F;
    }
}
