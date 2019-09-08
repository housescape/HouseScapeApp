package pl.sda.housescape.creator;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/create")
public class GameCreatorController {

    @RequestMapping
    public ModelAndView getCreatorGamePage() {
        ModelAndView mnv = new ModelAndView("create");
        return mnv;
    }


}