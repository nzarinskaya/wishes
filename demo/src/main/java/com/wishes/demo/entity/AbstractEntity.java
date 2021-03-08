package com.wishes.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AbstractEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Long id;

    public AbstractEntity(Long id) {
        this.id = id;
    }

    public AbstractEntity(Long id, Long timestamp) {
        this.id = id;
    }

    public AbstractEntity() {
    }


    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
