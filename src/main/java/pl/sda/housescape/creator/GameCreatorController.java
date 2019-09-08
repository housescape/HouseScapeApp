package pl.sda.housescape.creator;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/game-creator")
public class GameCreatorController {

//    private final GameCreatorService gameCreatorService;
//
//    public GameCreatorController(GameCreatorService gameCreatorService) {
//        this.gameCreatorService = gameCreatorService;
//    }

    @RequestMapping
    public ModelAndView getCreatorGamePage() {
        ModelAndView mnv = new ModelAndView("create-game");
        return mnv;
    }
}
