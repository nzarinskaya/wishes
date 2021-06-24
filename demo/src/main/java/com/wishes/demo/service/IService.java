package com.wishes.demo.service;

import com.wishes.demo.entity.IEntity;
import com.wishes.demo.model.IModel;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

public interface IService<E extends IEntity,M extends IModel> {

    Optional<M> getById(Long id);
    Collection<M> getAll();
    Collection<M> getAllById(Collection<Long> ids);

}
