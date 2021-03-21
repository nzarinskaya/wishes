package com.wishes.demo.controller.registration;

import com.wishes.demo.controller.AbstractController;
import com.wishes.demo.model.auth.RegistrationModel;
import com.wishes.demo.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
    @RequestMapping("/registration")
    public class RegistrationController extends AbstractController {

        private UserServiceImpl userService;

        @GetMapping
        public String registration() {
            return "registration";
        }

        @ModelAttribute("registrationForm")
        public RegistrationModel registrationModel() {
            return new RegistrationModel();
        }

        @PostMapping
        public String saveRegistration(@ModelAttribute("registrationForm") RegistrationModel registrationModel, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "redirect:/login?error";
            }
            userService.saveUser(registrationModel);
            return "redirect:/main";
        }

        @Autowired
        public void setUserService(UserServiceImpl userService) {
            this.userService = userService;
        }
    }

