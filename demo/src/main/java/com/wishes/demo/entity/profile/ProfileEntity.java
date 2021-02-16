package com.wishes.demo.entity.profile;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.account_setting.AccountSettingEntity;
import com.wishes.demo.entity.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
public class ProfileEntity extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @OneToOne(optional = false)
    @JoinColumn(name = "account_setting_id_fk")
    private AccountSettingEntity accountSetting;

    @OneToOne(optional = false,mappedBy = "profile")
    private UserEntity userProfile;

    public ProfileEntity(Long id, String firstName, String lastName, LocalDate createdOn) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdOn = createdOn;
    }
    public ProfileEntity( String firstName, String lastName, LocalDate createdOn) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdOn = createdOn;
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

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public AccountSettingEntity getAccountSetting() {
        return accountSetting;
    }

    public void setAccountSetting(AccountSettingEntity accountSetting) {
        this.accountSetting = accountSetting;
    }

    public UserEntity getUser() {
        return userProfile;
    }

    public void setUser(UserEntity user) {
        this.userProfile = user;
    }

    @Override
    public Long getId() {
        return id;
    }

}
