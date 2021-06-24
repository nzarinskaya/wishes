package com.wishes.demo.converter.model.user;

import com.wishes.demo.converter.model.AbstractEtoMConverter;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.model.user.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractEtoMConverter<UserEntity,UserModel> {

    @Override
    protected UserModel convertToModel(UserEntity source, UserModel target) {
        target.setLogin(source.getLogin());
        return target;
    }

    @Override
    protected UserEntity convertToEntity(UserEntity source,UserModel target) {
        source.setLogin(target.getLogin());
        return source;
    }

    @Override
    protected UserModel createTarget() {
        return new UserModel();
    }

    @Override
    protected UserEntity createSource() {
        return new UserEntity();
    }
}
