package com.wishes.demo.entity.users_relations;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.repository.converter.relation_status.RelationStatusAttributeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users_relations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserRelationEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "primary_user_id_fk")
    private UserEntity primaryUser;

    @ManyToOne
    @JoinColumn(name = "related_user_id_fk")
    private UserEntity relatedUser;

    @Convert(converter = RelationStatusAttributeConverter.class)
    @Column(name = "status")
    private RelationStatusEnum status;

    public UserRelationEntity() {
    }


    public UserRelationEntity(Long id, UserEntity primaryUser, UserEntity relatedUser, RelationStatusEnum status) {
        super(id);
        this.primaryUser = primaryUser;
        this.relatedUser = relatedUser;
        this.status = status;
    }
    public UserRelationEntity( UserEntity primaryUser, UserEntity relatedUser, RelationStatusEnum status) {
        super();
        this.primaryUser = primaryUser;
        this.relatedUser = relatedUser;
        this.status = status;
    }

    public UserEntity getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(UserEntity primaryUser) {
        this.primaryUser = primaryUser;
    }

    public UserEntity getRelatedUser() {
        return relatedUser;
    }

    public void setRelatedUser(UserEntity relatedUser) {
        this.relatedUser = relatedUser;
    }

    public RelationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RelationStatusEnum status) {
        this.status = status;
    }
}
