package com.wishes.demo.repository.user_relations;

import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.entity.users_relations.RelationStatus;
import com.wishes.demo.entity.users_relations.UserRelationEntity;
import com.wishes.demo.repository.BaseRepository;

import java.awt.font.OpenType;
import java.util.Optional;

public interface UserRelationRepository extends BaseRepository <UserRelationEntity, Long>{
    Optional<UserRelationEntity> findByStatus(RelationStatus status);
    UserRelationEntity findById(long id);

}
