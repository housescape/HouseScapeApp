package pl.sda.housescape.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.game.service.GameService;
import pl.sda.housescape.upload.ImageStorageService;
import pl.sda.housescape.upload.UploadImage;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final ImageStorageService imageStorageService;

    public GameController(GameService gameService, ImageStorageService imageStorageService) {
        this.gameService = gameService;
        this.imageStorageService = imageStorageService;
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

    @PostMapping("/{idGame}")
    public ModelAndView addStep
            (@ModelAttribute("newStep") @Validated StepForm stepForm,
             BindingResult bindingResult, @PathVariable long idGame) {
        gameService.addStep(stepForm, idGame);
        return new ModelAndView("redirect:/game/{idGame}");
    }
    @RequestMapping("/{idGame}")
    public ModelAndView editGame(@PathVariable long idGame) {
        ModelAndView mnv = new ModelAndView("edit");
        mnv.addObject("game", gameService.editGame(idGame));
        mnv.addObject("newStep", new StepForm());
        mnv.addObject("stepList", gameService.getSteps(idGame));
        mnv.addObject("images", imageStorageService.getImages());
        return mnv;
    }

    @RequestMapping("/delete/{idGame}")
    public ModelAndView deleteGame(@PathVariable long idGame) {
        gameService.remove(idGame);
        return new ModelAndView("redirect:/game");
    }



}