package com.wishes.demo.dao;

import com.wishes.demo.entity.IEntity;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractDAO<E extends IEntity> implements DAO<E> {

    protected Logger logger;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
