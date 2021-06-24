package com.wishes.demo.model.user;

import com.wishes.demo.model.AbstractModel;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class UserModel extends AbstractModel {
    @NotBlank
    private String login;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    private String password;

    public UserModel() {

    }

    public UserModel(@NotBlank String login, @NotBlank String firstName, @NotBlank String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserModel(@NotBlank String login, @NotBlank String firstName, @NotBlank String lastName, String password) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
