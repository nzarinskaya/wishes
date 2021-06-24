package com.wishes.demo.model.wishes;

import com.wishes.demo.model.AbstractModel;
import java.time.LocalDate;

public class WishesModel extends AbstractModel {

    private String img_path;

    private String url_img;

    private String url;

    private double price;

    private String description;

    private LocalDate createdOn;

    public WishesModel() {
    }

    public WishesModel(String url_img, double price, String description, LocalDate createdOn) {
        this.url_img = url_img;
        this.price = price;
        this.description = description;
        this.createdOn = createdOn;
    }


    public WishesModel(String img_path, String url, double price, String description, LocalDate createdOn) {
        this.img_path = img_path;
        this.url = url;
        this.price = price;
        this.description = description;
        this.createdOn = createdOn;
    }

    public WishesModel(String img_path, String url_img, String url, double price, String description, LocalDate createdOn) {
        this.img_path = img_path;
        this.url_img = url_img;
        this.url = url;
        this.price = price;
        this.description = description;
        this.createdOn = createdOn;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
