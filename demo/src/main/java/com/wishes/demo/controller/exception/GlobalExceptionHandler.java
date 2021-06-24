package com.wishes.demo.controller.exception;

import com.wishes.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFound(Throwable e) {
        return new ModelAndView("error/404", "errorMessage", e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public String handleGlobal(Model model, Throwable e) {
        logger.error("Unhandled error: {}", e.getMessage(), e);
        model.addAttribute("errorMessage", e.getMessage());
        return "error/500";
    }

    @Autowired
    public void setLog(Logger logger) {
        this.logger = logger;
    }
}
