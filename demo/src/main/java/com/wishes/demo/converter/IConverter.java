package com.wishes.demo.converter;

import java.util.List;
import com.wishes.demo.entity.IEntity;
import com.wishes.demo.model.IModel;

public interface IConverter<M extends IModel, E extends IEntity> {

    M convertToModel(E entity);
    E convertToEntity(M model);
    List<M> convertAllToModels(List<E> entities);
    List<E> convertAllToEntities(List<M> models);

}