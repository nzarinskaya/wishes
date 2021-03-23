package com.wishes.demo.service.wishes;

import com.wishes.demo.entity.wishes.WishesEntity;
import com.wishes.demo.model.auth.RegistrationModel;
import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.model.wishes.WishesModel;
import com.wishes.demo.service.IService;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IWishesService extends IService<WishesEntity, WishesModel> {

    WishesModel addWishes(WishesModel wishesModel);
    void deleteWishes(Long id);
    Optional<WishesEntity> findAllWishes(Sort sort);
}
