package com.wishes.demo.repository.user;

import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.repository.AbstractRepositoryTest;
import com.wishes.demo.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest extends AbstractRepositoryTest<UserEntity, Long> {

    @Override
    protected UserEntity createEntity() {
        final UserEntity userEntity = new UserEntity();
        userEntity.setLogin("login");
        userEntity.setPassword("password");
        return userEntity;
    }

    @Override
    @Autowired
    protected void setRepository(BaseRepository<UserEntity, Long> repository) {
        this.repository = repository;
    }
}