package com.wishes.demo.repository.converter.relation_status;

import com.wishes.demo.entity.users_relations.RelationStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RelationStatusAttributeConverter implements AttributeConverter<RelationStatusEnum,String> {

    @Override
    public String convertToDatabaseColumn(RelationStatusEnum relationStatusEnum) {
        return relationStatusEnum.name();
    }

    @Override
    public RelationStatusEnum convertToEntityAttribute(String s) {
        return RelationStatusEnum.valueOf(s);
    }
}
