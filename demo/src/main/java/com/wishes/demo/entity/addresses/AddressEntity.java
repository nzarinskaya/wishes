package com.wishes.demo.entity.addresses;

import com.wishes.demo.entity.AbstractEntity;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.entity.wishes.WishesEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AddressEntity extends AbstractEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "postal_code")
    private String postal_code;

    @OneToOne (mappedBy="address")
    private UserEntity usersAddress;

    public AddressEntity() {
    }

    public AddressEntity(Long id, String country) {
        super(id);
        this.country = country;
    }
    public AddressEntity( String country) {
        super();
        this.country = country;
    }

    public AddressEntity(Long id, String city, String apartment) {
        super(id);
        this.city = city;
        this.apartment = apartment;
    }
    public AddressEntity( String city, String apartment) {
        super();
        this.city = city;
        this.apartment = apartment;
    }

    public AddressEntity(Long id, String country, String city, String street) {
        super(id);
        this.country = country;
        this.city = city;
        this.street = street;
    }
    public AddressEntity(String country, String city, String street) {
        super();
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public AddressEntity(Long id, String country, String city, String street, String house) {
        super(id);
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }
    public AddressEntity( String country, String city, String street, String house) {
        super();
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public AddressEntity(Long id, String country, String city, String street, String house, String apartment) {
        super(id);
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }
    public AddressEntity( String country, String city, String street, String house, String apartment) {
        super();
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public AddressEntity(String country, String city, String street, String house, String apartment, String postal_code) {
        super();
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postal_code = postal_code;
    }

    public AddressEntity(Long id, String country, String city, String street, String house, String apartment, String postal_code) {
        super(id);
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @Override
    public Long getId() {
        return id;
    }
}
