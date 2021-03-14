package com.wishes.demo.model.user;

import com.wishes.demo.model.AbstractModel;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class UserModel extends AbstractModel {
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    public UserModel() {
    }

    public UserModel(@NotBlank String login, @NotBlank String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
