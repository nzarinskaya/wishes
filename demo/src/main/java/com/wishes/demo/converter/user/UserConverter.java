package com.wishes.demo.converter.user;

import com.wishes.demo.converter.AbstractConverter;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.model.user.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserModel, UserEntity> {
    @Override
    protected UserModel convertEntity(UserEntity entity, UserModel model) {
        model.setLogin(entity.getLogin());
        model.setPassword(entity.getPassword());
        return model;
    }

    @Override
    protected UserEntity convertModel(UserModel model, UserEntity entity) {
        entity.setLogin(model.getLogin());
        entity.setPassword(model.getPassword());
        return entity;
    }

    @Override
    protected UserModel createModel() {
        return new UserModel();
    }

    @Override
    protected UserEntity createEntity() {
        return new UserEntity();
    }
}
