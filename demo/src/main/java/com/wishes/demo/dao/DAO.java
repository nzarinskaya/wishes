package com.wishes.demo.dao;

import com.wishes.demo.dao.exception.DAOException;
import com.wishes.demo.entity.IEntity;

import java.util.List;
import java.util.Optional;

public interface DAO<E extends IEntity> {

    E create(E entity) throws DAOException;
    Optional<E> getEntity(Long id) throws DAOException;
    E updateEntity(E entity) throws DAOException;
    void deleteEntity( Long id) throws DAOException;
    List<E> getAllEntity() throws DAOException;
}
