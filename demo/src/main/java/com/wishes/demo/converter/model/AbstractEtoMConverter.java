package com.wishes.demo.converter.model;

import com.wishes.demo.converter.AbstractConverter;
import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.IEntity;
import com.wishes.demo.model.AbstractModel;
import com.wishes.demo.model.IModel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEtoMConverter <S extends IEntity,T extends IModel>
        extends AbstractConverter<S,T> implements EtoMConverter<S,T>  {

    @Override
    public T convert(S source){
        final T target = createTarget();
        ((AbstractModel)target).setId(source.getId());
        return convertToModel(source,target);
    }

    @Override
    public S convertBack(T target){
        final S source = createSource();
        ((AbstractEntity)target).setId(target.getId());
        return convertToEntity(source,target);
    }

    protected abstract S convertToEntity(S source, T target);
    protected abstract T convertToModel(S source, T target);

}
