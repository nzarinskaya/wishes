package com.wishes.demo.controller.profile;

import com.wishes.demo.controller.AbstractController;
import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.service.auth.dto.UserDetailsDTO;
import com.wishes.demo.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileContr extends AbstractController {

    UserServiceImpl userService;

    @GetMapping()
    public ModelAndView profile(Authentication authentication) {
        UserModel user = ((UserDetailsDTO) authentication.getPrincipal()).getUserModel();

        ModelAndView mav = new ModelAndView("/profile", "user", user);
        return mav;

    }
    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
