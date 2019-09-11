package pl.sda.housescape.game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

    //GameService gameService = new GameService();

    @RequestMapping
    public ModelAndView getGamesPage(){
        ModelAndView mnv = new ModelAndView("game");
        //mnv.addObject("game", gameService.getGames());
        return mnv;
    }
}

