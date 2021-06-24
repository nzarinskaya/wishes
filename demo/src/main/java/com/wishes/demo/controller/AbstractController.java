package com.wishes.demo.controller;

import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.service.auth.dto.UserDetailsDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractController implements IController {

    protected Logger logger;


    protected void addUser(ModelAndView modelAndView){
        addUser(modelAndView, SecurityContextHolder.getContext().getAuthentication());
    }

    private void addUser(ModelAndView modelAndView, Authentication authentication){
        UserDetailsDTO userDetails = (UserDetailsDTO) authentication.getPrincipal();
        addUser(modelAndView,userDetails.getUserModel());

    }

    protected void addUser(ModelAndView modelAndView, UserModel userModel){
        modelAndView.addObject("user",userModel);
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
