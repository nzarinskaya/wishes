package com.wishes.demo.repository.impl;

import com.wishes.demo.entity.IEntity;
import com.wishes.demo.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public class BaseRepositoryImpl<E extends IEntity,PK extends Serializable>
        extends SimpleJpaRepository<E,PK> implements BaseRepository<E,PK> {
    private EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseRepositoryImpl.class);


    public BaseRepositoryImpl(JpaEntityInformation<E, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<E> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }
    @Override
    public List<E> findAll() {
        LOGGER.info("findAll() method from {}", this.getClass().getSimpleName());
        return super.findAll();
    }

}
