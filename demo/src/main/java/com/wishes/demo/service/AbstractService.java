package com.wishes.demo.service;

import com.wishes.demo.converter.model.EtoMConverter;

import com.wishes.demo.entity.IEntity;
import com.wishes.demo.model.IModel;
import com.wishes.demo.model.auth.RegistrationModel;
import com.wishes.demo.repository.BaseRepository;

import java.util.Collection;
import java.util.Optional;

public abstract  class AbstractService<E extends IEntity,M extends IModel> implements IService<E,M> {

    protected BaseRepository<E,Long> repository;
    protected EtoMConverter<E,M> converter;


    @Override
    public Optional<M> getById(Long id) {
        Optional<E> entity = repository.findById(id);
        return entity.map(e -> converter.convert(e));
    }

    @Override
    public Collection<M> getAll() {
        return converter.convertAll(repository.findAll());
    }

    @Override
    public Collection<M> getAllById(Collection<Long> ids) {
        return converter.convertAll(repository.findAllById(ids));
    }

    protected Iterable<E> getEntitiesByIds(Collection<Long> ids){
        return repository.findAllById(ids);
   }

}
