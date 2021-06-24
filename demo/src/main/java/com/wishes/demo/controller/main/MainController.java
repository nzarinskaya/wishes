package com.wishes.demo.controller.main;

import com.wishes.demo.controller.AbstractController;
import com.wishes.demo.model.auth.RegistrationModel;
import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/main")
public class MainController extends AbstractController {

    UserServiceImpl userService;

    @GetMapping()
    public ModelAndView login(@RequestParam Optional<String> error) {
        final ModelAndView modelAndView = new ModelAndView("main");
        if (error.isPresent()) {
            modelAndView.addObject("errorMessage", "Error occurred");
        }
        return modelAndView;
    }

/*
    @PostMapping("/login")
    public String login(@RequestParam String login,@RequestParam String password, BindingResult bindingResult){
        userService.getByLoginAndPassword(login,password);
        if (bindingResult.hasErrors()) {
            return "redirect:/login?error";
        }
        return "profile";
    }
 */


    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
