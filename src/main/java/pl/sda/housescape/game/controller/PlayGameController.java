package pl.sda.housescape.game.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.game.service.GameService;
import pl.sda.housescape.game.service.PlayGameService;

@Controller
@RequestMapping("/play")
public class PlayGameController {

    private final PlayGameService playGameService;
    private final GameService gameService;



    public PlayGameController(PlayGameService playGameService, GameService gameService) {
        this.playGameService = playGameService;
        this.gameService = gameService;
    }

    @RequestMapping
    public ModelAndView playGames() {
        ModelAndView mnv = new ModelAndView("game-list-to-play");
        mnv.addObject("games", playGameService.getGamesToPlay());

        return mnv;
    }

    @RequestMapping("/{idGame}/{idStep}")
    public ModelAndView nextStep(@PathVariable Long idGame, @PathVariable Long idStep) {
        ModelAndView mnv = new ModelAndView("gamestep");
        mnv.addObject("steps",gameService.getStep(idStep));
        return mnv;
    }
//    @PostMapping("/{idGame}")
//    public ModelAndView getCode()

}
