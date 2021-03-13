package com.wishes.demo.repository.converter.access_status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class AccessStatusAttributeConverter implements AttributeConverter<Boolean,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Boolean aBoolean) {
        if (Boolean.TRUE.equals(aBoolean)){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public Boolean convertToEntityAttribute(Integer integer) {
        if (integer == null) {
            return Boolean.FALSE;
        }
        else {
            return (integer == 0) ? Boolean.FALSE : Boolean.TRUE;
        }
    }
}
