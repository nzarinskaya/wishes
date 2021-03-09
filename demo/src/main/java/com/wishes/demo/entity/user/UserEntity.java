package com.wishes.demo.entity.user;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.access.AccessEntity;
import com.wishes.demo.entity.addresses.AddressEntity;
import com.wishes.demo.entity.profile.ProfileEntity;
import com.wishes.demo.entity.users_relations.UserRelationEntity;
import com.wishes.demo.entity.wishes.WishesEntity;
import org.hibernate.annotations.Where;
import java.util.List;


import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity extends AbstractEntity {

    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    @OneToMany(mappedBy = "relatedUser",cascade = CascadeType.ALL)
    @Where(clause = "status = 'ACCEPTED'")
    private Set<UserRelationEntity> friends;

    @OneToMany(mappedBy = "primaryUser",cascade = CascadeType.ALL)
    @Where(clause = "status = 'FRIEND_REQUEST'")
    private Set<UserRelationEntity> pendingRequests;

    @OneToMany(mappedBy = "relatedUser",cascade = CascadeType.ALL)
    @Where(clause = "status = 'FRIEND_REQUEST'")
    private Set<UserRelationEntity> receivedRequests;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<WishesEntity> wishes;

    @OneToMany(mappedBy = "primaryUserAccess",cascade = CascadeType.ALL)
    private List<AccessEntity> accessSet;

    @OneToMany(mappedBy = "relatedUserAccess",cascade = CascadeType.ALL)
    private List<AccessEntity> accessApply;

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id_fk")
    private AddressEntity address;

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id_fk")
    private ProfileEntity profile;

    public UserEntity() {
    }

    public UserEntity(Long id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    public UserEntity(String login, String password) {
        super();
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

    public Set<UserRelationEntity> getFriends() {
        return friends;
    }

    public void setFriends(Set<UserRelationEntity> friends) {
        this.friends = friends;
    }

    public Set<UserRelationEntity> getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(Set<UserRelationEntity> pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public Set<UserRelationEntity> getReceivedRequests() {
        return receivedRequests;
    }

    public void setReceivedRequests(Set<UserRelationEntity> receivedRequests) {
        this.receivedRequests = receivedRequests;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(friends, that.friends) &&
                Objects.equals(pendingRequests, that.pendingRequests) &&
                Objects.equals(receivedRequests, that.receivedRequests) &&
                Objects.equals(wishes, that.wishes) &&
                Objects.equals(accessSet, that.accessSet) &&
                Objects.equals(accessApply, that.accessApply) &&
                Objects.equals(address, that.address) &&
                Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, friends, pendingRequests, receivedRequests, wishes, accessSet, accessApply, address, profile);
    }
}
