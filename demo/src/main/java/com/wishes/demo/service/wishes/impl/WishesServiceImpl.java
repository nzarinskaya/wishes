package com.wishes.demo.service.wishes.impl;

import com.wishes.demo.converter.model.wishes.WishesConverter;
import com.wishes.demo.entity.wishes.WishesEntity;
import com.wishes.demo.model.wishes.WishesModel;
import com.wishes.demo.repository.exception.RepositoryException;
import com.wishes.demo.repository.wishes.WishesRepository;
import com.wishes.demo.service.AbstractService;
import com.wishes.demo.service.exception.ServiceException;
import com.wishes.demo.service.wishes.IWishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.Optional;

public class WishesServiceImpl extends AbstractService<WishesEntity, WishesModel> implements IWishesService {

    private WishesRepository wishesRepository;
    private WishesConverter wishesConverter;


    @Override
    public WishesModel addWishes(WishesModel wishesModel) {
        WishesEntity addWishes;
        try {

            WishesEntity wishesEntity = wishesConverter.convertBack(wishesModel);
            addWishes = wishesRepository.save(wishesEntity);
        } catch (RepositoryException ex) {
            throw new ServiceException("Unable to add wishes: " + ex.getMessage(), ex);
        }

        return wishesConverter.convert(addWishes);
    }


    @Override
    public Optional<WishesEntity> findAllWishes(Sort sort) {
        return wishesRepository.findAllWishes(Sort.by(Direction.ASC,"price"));
    }

    @Override
    public void deleteWishes(Long id) {
        wishesRepository.deleteById(id);
    }

    @Autowired
    public void setWishesConverter(WishesConverter wishesConverter) {
        this.wishesConverter = wishesConverter;
    }
    @Autowired
    public void setWishesRepository(WishesRepository wishesRepository) {
        this.wishesRepository = wishesRepository;
    }
}
