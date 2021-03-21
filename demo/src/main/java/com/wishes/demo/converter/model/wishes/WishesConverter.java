package com.wishes.demo.converter.model.wishes;

import com.wishes.demo.converter.model.AbstractEtoMConverter;
import com.wishes.demo.entity.wishes.WishesEntity;
import com.wishes.demo.model.wishes.WishesModel;

public class WishesConverter extends AbstractEtoMConverter<WishesEntity, WishesModel> {


    @Override
    public WishesEntity convertToEntity(WishesEntity source, WishesModel target) {
        source.setDescription(target.getDescription());
        source.setCreatedOn(target.getCreatedOn());
        source.setImg_path(target.getImg_path());
        source.setPrice(target.getPrice());
        source.setUrl(target.getUrl());
        source.setUrl_img(target.getUrl_img());
        return source;
    }

    @Override
    public WishesModel convertToModel(WishesEntity source, WishesModel target) {
        target.setDescription(source.getDescription());
        target.setCreatedOn(source.getCreatedOn());
        target.setImg_path(source.getImg_path());
        target.setPrice(source.getPrice());
        target.setUrl(source.getUrl());
        target.setUrl_img(source.getUrl_img());
        return target;
    }

    @Override
    protected WishesModel createTarget() {
        return new WishesModel();
    }

    @Override
    protected WishesEntity createSource() {
        return new WishesEntity();
    }
}
