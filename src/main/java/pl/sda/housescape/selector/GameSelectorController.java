package pl.sda.housescape.selector;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/play")
public class GameSelectorController {

    private final GameSelectorService gameSelectorService;

    public GameSelectorController(GameSelectorService gameSelectorService) {
        this.gameSelectorService = gameSelectorService;

    }
    @RequestMapping
    public ModelAndView getGamesPage(){
        ModelAndView mnv = new ModelAndView("play");
      //  mnv.addObject("games", gameSelectorService.getGames());
        return mnv;
        //comm
    }
}
