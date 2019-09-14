package pl.sda.housescape.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.game.service.GameService;

@Controller
@RequestMapping ("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping
    public ModelAndView getGames() {
        ModelAndView mnv = new ModelAndView("game-list");
        mnv.addObject("games", gameService.getGames());
        return mnv;
    }

    @RequestMapping("/new")
    public ModelAndView getCreatorGamePage() {
        ModelAndView mnv = new ModelAndView("create");
        mnv.addObject("newGame", new GameForm());
        return mnv;
    }

    @PostMapping("/new")
    public ModelAndView addGame
            (@ModelAttribute("newGame") @Validated GameForm gameForm,
             BindingResult bindingResult) {
        gameService.addGame(gameForm);
        return new ModelAndView("redirect:/game");
    }
}