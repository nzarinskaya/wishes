package com.wishes.demo.entity.access;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.account_setting.AccountSettingEntity;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.repository.converter.access_status.AccessStatusAttributeConverter;
import com.wishes.demo.repository.converter.relation_status.RelationStatusAttributeConverter;

import javax.persistence.Id;


import javax.persistence.*;

@Entity
@Table(name = "access")
public class AccessEntity extends AbstractEntity {

    @Convert(converter = AccessStatusAttributeConverter.class)
    @Column(name = "status")
    private boolean status;

   @ManyToOne
   @JoinColumn(name = "user_id_fk")
   private UserEntity primaryUserAccess;

   @ManyToOne
   @JoinColumn(name = "user_related_id_fk")
   private UserEntity relatedUserAccess;

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_setting_id_fk")
    private AccountSettingEntity account_Setting;


    public AccessEntity() {
    }

    public AccessEntity(Long id, boolean status, UserEntity primaryUserAccess, UserEntity relatedUserAccess) {
        super(id);
        this.status = status;
        this.primaryUserAccess = primaryUserAccess;
        this.relatedUserAccess = relatedUserAccess;
    }
    public AccessEntity( boolean status, UserEntity primaryUserAccess, UserEntity relatedUserAccess) {
        super();
        this.status = status;
        this.primaryUserAccess = primaryUserAccess;
        this.relatedUserAccess = relatedUserAccess;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserEntity getPrimaryUserAccess() {
        return primaryUserAccess;
    }

    public void setPrimaryUserAccess(UserEntity primaryUserAccess) {
        this.primaryUserAccess = primaryUserAccess;
    }

    public UserEntity getRelatedUserAccess() {
        return relatedUserAccess;
    }

    public void setRelatedUserAccess(UserEntity relatedUserAccess) {
        this.relatedUserAccess = relatedUserAccess;
    }

}
