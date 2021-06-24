package com.wishes.demo.service.user;

import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.model.auth.RegistrationModel;
import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.service.IService;

import java.util.List;
import java.util.Optional;


public interface IUserService extends IService<UserEntity,UserModel> {

    UserModel saveUser(RegistrationModel registrationModel);
    Optional<UserModel> getByLogin(String login);
    void deleteUser(Long id);

    Optional<UserModel> getByLoginAndPassword(String login, String password);

}
