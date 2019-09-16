package pl.sda.housescape.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.game.service.GameService;
import pl.sda.housescape.game.service.PlayGameService;
import pl.sda.housescape.upload.ImageStorageService;

@Controller
@RequestMapping("/play")
public class PlayGameController {

    private final PlayGameService playGameService;
    private final GameService gameService;
    private final ImageStorageService imageStorageService;


    public PlayGameController(PlayGameService playGameService, GameService gameService, ImageStorageService imageStorageService) {
        this.playGameService = playGameService;
        this.gameService = gameService;
        this.imageStorageService = imageStorageService;
    }

    @RequestMapping
    public ModelAndView playGames() {
        ModelAndView mnv = new ModelAndView("game-list-to-play");
        mnv.addObject("games", playGameService.getGamesToPlay());
        mnv.addObject("firstIdStep", playGameService.findFirstIdStep());
        return mnv;
    }

    @RequestMapping("/{idGame}/{idStep}")
    public ModelAndView Step(@PathVariable Long idGame, @PathVariable Long idStep) {
        ModelAndView mnv = new ModelAndView("gamestep");
        mnv.addObject("images", imageStorageService.getImages());
        mnv.addObject("game", gameService.editGame(idGame));
        mnv.addObject("stepList", gameService.getSteps(idGame));
        mnv.addObject("oneStep", gameService.getStep(idStep));
        mnv.addObject("idStep",idStep);
       // mnv.addObject("codeToUnblock", new String());
        return mnv;
    }



}
