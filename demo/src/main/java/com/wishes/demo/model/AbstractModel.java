package com.wishes.demo.model;

public abstract class AbstractModel implements IModel {
    protected Long id;
    @Override
    public Long getId() {
        return null;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
