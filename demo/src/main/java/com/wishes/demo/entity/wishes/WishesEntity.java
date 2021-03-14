package com.wishes.demo.entity.wishes;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.repository.converter.date.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wishes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WishesEntity extends AbstractEntity {

    @Column (name = "img_path")
    private String img_path;

    @Column(name = "url_img")
    private String url_img;

    @Column(name = "url")
    private String url;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "created_on")
    private LocalDate createdOn;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private UserEntity user;

    public WishesEntity() {
    }

    public WishesEntity(Long id, String url, LocalDate createdOn) {
        super(id);
        this.url = url;
        this.createdOn = createdOn;
    }
    public WishesEntity( String url, LocalDate createdOn) {
        super();
        this.url = url;
        this.createdOn = createdOn;
    }


    public WishesEntity(Long id, String img_path, double price, String description, LocalDate createdOn) {
        super(id);
        this.img_path = img_path;
        this.price = price;
        this.description = description;
        this.createdOn = createdOn;
    }

    public WishesEntity(String img_path, double price, String description, LocalDate createdOn) {
        super();
        this.img_path = img_path;
        this.price = price;
        this.description = description;
        this.createdOn = createdOn;
    }

    @Override
    public Long getId() {
        return id;
    }


}
