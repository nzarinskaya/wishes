package com.wishes.demo.repository.user;

import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.repository.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);
    UserEntity findById(long id);
}
