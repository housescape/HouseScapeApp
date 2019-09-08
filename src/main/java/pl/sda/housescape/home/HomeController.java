package pl.sda.housescape.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public ModelAndView getHomePage(){
        ModelAndView mnv = new ModelAndView("home");
        return mnv;
    }

}
