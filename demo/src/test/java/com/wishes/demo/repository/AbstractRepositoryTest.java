package com.wishes.demo.repository;

import com.wishes.demo.entity.IEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractRepositoryTest<E extends IEntity, PK extends Serializable> {

    protected BaseRepository<E, PK> repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void testCreate() {
       create();
    }

    @Test
    void testFind() {
        final E entity = create();
       Optional<E> entityOptional = repository.findById((PK)entity.getId());
       assertTrue(entityOptional.isPresent(),"Entity not found");
       assertEquals(entity,entityOptional.get());

    }

    private E create(){
        E entity = createEntity();
        assertNotNull(entity,"Entity should be non null");
        E result = repository.save(entity);
        assertNotNull(result,"Saved entity is null");
        assertNotNull(result.getId(),"Entity ID is null");
        return result;
    }



    protected abstract E createEntity();

    protected abstract void setRepository(BaseRepository<E, PK> repository);
}
