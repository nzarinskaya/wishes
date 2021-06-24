package com.wishes.demo.service.user.impl;

import com.wishes.demo.converter.IConverter;
import com.wishes.demo.converter.model.user.UserConverter;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.model.auth.RegistrationModel;
import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.repository.user.UserRepository;
import com.wishes.demo.service.AbstractService;
import com.wishes.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class UserServiceImpl extends AbstractService<UserEntity,UserModel> implements IUserService {

    private  UserRepository userRepository;
    private UserConverter userConverter;

    @Override
    public UserModel saveUser(RegistrationModel registrationModel) {
        UserModel userModel = new UserModel();
        userModel.setLogin(registrationModel.getLogin());
        userModel.setFirstName(registrationModel.getFirstName());
        userModel.setLastName(registrationModel.getLastName());


        UserEntity userEntity = userConverter.convertBack(userModel);
        userEntity.setPassword(registrationModel.getPassword());
        UserEntity save = userRepository.save(userEntity);
        return userConverter.convert(save);
    }

    @Override
    public Optional<UserModel> getByLogin(String login) {

        Optional<UserEntity> userGet = userRepository.findByLogin(login);
        return userGet.map(u -> userConverter.convert(u));
    }

    @Override
    public Optional<UserModel> getByLoginAndPassword(String login, String password) {

        Optional<UserEntity> userGet = userRepository.findByLoginAndPassword(login,password);
        return userGet.map(u -> userConverter.convert(u));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }
}
