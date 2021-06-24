package com.wishes.demo.converter.model;

import java.util.List;

import com.wishes.demo.converter.AbstractConverter;
import com.wishes.demo.converter.IConverter;
import com.wishes.demo.entity.IEntity;
import com.wishes.demo.model.IModel;

public interface EtoMConverter<S extends IEntity,T extends IModel> extends IConverter<S,T> {

     T convert(S source);
     S convertBack(T target);

}