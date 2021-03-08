package com.wishes.demo.entity.users_relations;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.user.UserEntity;

import javax.persistence.*;

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

    @Column(name = "status")
    private RelationStatus status;

    public UserRelationEntity() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public UserRelationEntity(Long id, UserEntity primaryUser, UserEntity relatedUser, RelationStatus status) {
        super(id);
        this.primaryUser = primaryUser;
        this.relatedUser = relatedUser;
        this.status = status;
    }
    public UserRelationEntity( UserEntity primaryUser, UserEntity relatedUser, RelationStatus status) {
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

    public RelationStatus getStatus() {
        return status;
    }

    public void setStatus(RelationStatus status) {
        this.status = status;
    }
}
