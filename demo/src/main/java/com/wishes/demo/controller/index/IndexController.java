package com.wishes.demo.controller.index;

import com.wishes.demo.controller.AbstractController;
import com.wishes.demo.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController extends AbstractController {

    @GetMapping
    public String index() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public ModelAndView login(@RequestParam Optional<String> error) {
        final ModelAndView modelAndView = new ModelAndView("main");
        if (error.isPresent()) {
            modelAndView.addObject("errorMessage", "Error occurred");
        }
        return modelAndView;
    }

    @GetMapping("/registration")
    public String registration() {
        return "/registration/registration";
    }


}