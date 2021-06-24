package com.wishes.demo.service.auth.dto;

import com.wishes.demo.model.user.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsDTO extends User {

    private UserModel userModel;


    public UserDetailsDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetailsDTO(UserModel userModel, UserDetails user) {
        super(user.getUsername(),user.getPassword(), user.getAuthorities());
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }
}
