package com.wishes.demo.repository.converter.passowrd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
@Component
public class PasswordAttributeConverter implements AttributeConverter<String,String> {

    private PasswordEncoder encoder;


    @Override
    public String convertToDatabaseColumn(String s) {
        return encoder.encode(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s;
    }

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
    
}

