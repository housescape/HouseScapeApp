package pl.sda.housescape.creator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.model.NewGame;

@Controller
@RequestMapping ("/create")
public class GameCreatorController {

    private final GameCreatorService gameCreatorService;

    public GameCreatorController(GameCreatorService gameCreatorService) {
        this.gameCreatorService = gameCreatorService;
    }

    @RequestMapping
    public ModelAndView getCreatorGamePage() {
        ModelAndView mnv = new ModelAndView("create");
        mnv.addObject("newGame", new NewGame());
        return mnv;
    }

    @PostMapping("/create")
    public ModelAndView addGame
            (@ModelAttribute("newGame") @Validated NewGame newGame,
             BindingResult bindingResult) {
        gameCreatorService.addGame(newGame);
        return new ModelAndView("redirect:/stepcreator");
    }

}