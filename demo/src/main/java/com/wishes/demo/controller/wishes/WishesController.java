package com.wishes.demo.controller.wishes;

import com.wishes.demo.controller.AbstractController;
import com.wishes.demo.converter.IConverter;
import com.wishes.demo.converter.model.wishes.WishesConverter;
import com.wishes.demo.entity.wishes.WishesEntity;
import com.wishes.demo.model.wishes.WishesModel;
import com.wishes.demo.service.exception.ServiceException;
import com.wishes.demo.service.wishes.impl.WishesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/wishes")
public class WishesController extends AbstractController {

    WishesServiceImpl wishesService;
    IConverter<WishesEntity,WishesModel> wishesConverter;


    @ModelAttribute("wishes")
    public WishesModel wishes(){
        return new WishesModel();
    }

    public static <T> List<T> optionalToList(Optional<List<T>>opt) {
        return opt.orElse(new ArrayList<>());
    }

    @GetMapping("/allWishes")
    public String getAllWishes(Model model) {
        model.addAttribute("allWishes",wishesService.findAllWishes(Sort.by(Direction.ASC,"price"));
        return "/wishes";
    }



    @GetMapping
    public String allWishes(){
        return "wishes/wishes";
    }

    @GetMapping("/add")
    public String getAddWishes() {
        return "wishes/wishes-add";
    }

    @PostMapping("/add")
    public ModelAndView addWishes(@ModelAttribute("wishes") WishesModel wishesModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("wishes/wishes-add");
        }
        WishesModel addWishes;
        try {
            addWishes = wishesService.addWishes(wishesModel);
        } catch (ServiceException e) {
            return new ModelAndView("wishes/wishes-add", "message", e.getMessage());
        }
        return new ModelAndView("redirect:/wishes/" + addWishes.getId(), "wishes", addWishes);
    }

    @PostMapping("/delete")
    public String delete(@PathVariable Long id){
        wishesService.deleteWishes(id);
        return "/wishes";
    }


    @Autowired
    public void setWishesService(WishesServiceImpl wishesService) {
        this.wishesService = wishesService;
    }
    @Autowired
    public void setWishesConverter(WishesConverter wishesConverter) {
        this.wishesConverter = wishesConverter;
    }
}
