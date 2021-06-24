package com.wishes.demo.repository;

import com.wishes.demo.entity.IEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E extends IEntity, PK extends Serializable> extends PagingAndSortingRepository<E,PK> {

}
