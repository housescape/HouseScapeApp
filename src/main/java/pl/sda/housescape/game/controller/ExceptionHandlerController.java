package pl.sda.housescape.game.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.exception.NotFoundGameException;


@ControllerAdvice // kontroler ma zasęg globalny
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundGameException.class)
    public ModelAndView GameNotFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}