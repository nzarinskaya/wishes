package com.wishes.demo.repository.profile;

import com.wishes.demo.entity.profile.ProfileEntity;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.repository.BaseRepository;

import java.util.Optional;

public interface ProfileRepository extends BaseRepository<ProfileEntity,Long> {
    Optional<ProfileEntity> findByFirstNameAndLastName(String firstName,String lastName);
    }
