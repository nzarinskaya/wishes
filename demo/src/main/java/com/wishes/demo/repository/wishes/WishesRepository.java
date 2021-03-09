package com.wishes.demo.repository.wishes;

import com.wishes.demo.entity.users_relations.UserRelationEntity;
import com.wishes.demo.entity.wishes.WishesEntity;
import com.wishes.demo.repository.BaseRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface WishesRepository extends BaseRepository<WishesEntity, Long> {

    @Query(value = "SELECT w FROM WishesEntity w")
    Optional<WishesEntity> findAllWishes(Sort sort);

    WishesEntity findById(long id);
}
