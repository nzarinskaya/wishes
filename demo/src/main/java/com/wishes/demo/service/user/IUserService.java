package com.wishes.demo.service.user;

import com.wishes.demo.model.auth.RegistrationModel;
import com.wishes.demo.model.user.UserModel;


public interface IUserService {

     UserModel saveUser(RegistrationModel registrationModel);
     UserModel findByLogin(String login);
     UserModel findById(Long id);

}