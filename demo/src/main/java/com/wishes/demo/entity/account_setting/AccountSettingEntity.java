package com.wishes.demo.entity.account_setting;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.access.AccessEntity;
import com.wishes.demo.entity.profile.ProfileEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "account_setting")
public class AccountSettingEntity extends AbstractEntity {

    @Column(name = "status_default")
    private boolean statusDefault;

   @OneToOne(optional = false,mappedBy = "accountSetting")
   private ProfileEntity profile;

  /*  @OneToOne(optional = false,mappedBy = "account_Setting")
    private AccessEntity access;

   */

    public AccountSettingEntity() {
    }

    public AccountSettingEntity(Long id, boolean statusDefault) {
        super(id);
        this.statusDefault = statusDefault;
    }
    public AccountSettingEntity (boolean statusDefault) {
        super();
        this.statusDefault = statusDefault;
    }
    @Override
    public Long getId() {
        return id;
    }

    public boolean isStatusDefault() {
        return statusDefault;
    }

    public void setStatusDefault(boolean statusDefault) {
        this.statusDefault = statusDefault;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }
}
