package com.wishes.demo.service.user.impl;

import com.wishes.demo.converter.IConverter;
import com.wishes.demo.converter.user.UserConverter;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.repository.user.UserRepository;
import com.wishes.demo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService  {

    private  UserRepository userRepository;
    private IConverter<UserModel, UserEntity> userConverter;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setUserConverter(IConverter<UserModel, UserEntity> userConverter) {
        this.userConverter = userConverter;
    }


}
