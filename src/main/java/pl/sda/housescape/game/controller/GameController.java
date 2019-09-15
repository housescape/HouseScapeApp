package pl.sda.housescape.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.game.service.GameService;
import pl.sda.housescape.upload.ImageStorageService;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final ImageStorageService imageStorageService;

    public GameController(GameService gameService, ImageStorageService imageStorageService) {
        this.gameService = gameService;
        this.imageStorageService = imageStorageService;
    }


//    @PostMapping("/{idGame}/upload")
//    public String uploadFile(@PathVariable long idGame, @RequestParam("file") MultipartFile file) {
//        imageStorageService.uploadImage(new UploadImage(file, file.getOriginalFilename()));
//        return "redirect:/game/{idGame}";
//    }

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
        mnv.addObject("images", imageStorageService.getImages());
        mnv.addObject("game", gameService.editGame(idGame));
        mnv.addObject("newStep", new StepForm());
        mnv.addObject("stepList", gameService.getSteps(idGame));
        mnv.addObject("images", imageStorageService.getImages());
        return mnv;
    }

    @RequestMapping("/delete/{idGame}")
    public ModelAndView deleteGame(@PathVariable long idGame) {
        gameService.removeGame(idGame);
        return new ModelAndView("redirect:/game");
    }

    @RequestMapping("/{idGame}/{idStep}")
    public ModelAndView editStepSite(@PathVariable long idGame, @PathVariable long idStep) {
        ModelAndView mnv = new ModelAndView("step-edit");
        mnv.addObject("newStep", new StepForm());
        mnv.addObject("idGame", idGame);
        mnv.addObject("idStep", idStep);
        mnv.addObject("size", gameService.getSteps(idGame).size());
        mnv.addObject("step", gameService.getStep(idStep));
        return mnv;
    }

    @RequestMapping("/delete-step/{idGame}/{idStep}")
    public ModelAndView deleteStep(@PathVariable long idStep, @PathVariable long idGame) {
        gameService.removeStep(idStep);
        return new ModelAndView("redirect:/game/{idGame}");
    }

    @PostMapping("/{idGame}/{idStep}")
    public ModelAndView editStep(@PathVariable long idGame, @PathVariable long idStep, @ModelAttribute("editStep") @Validated StepForm stepForm) {
        gameService.editStep(stepForm, idStep);
        return new ModelAndView("redirect:/game/{idGame}");
    }

    @RequestMapping("/done/{idGame}")
    public ModelAndView done(@PathVariable long idGame) {
        gameService.done(idGame);
        return new ModelAndView("redirect:/game");
    }
    @RequestMapping("/building/{idGame}")
    public ModelAndView building(@PathVariable long idGame) {
        gameService.building(idGame);
        return new ModelAndView("redirect:/game");
    }

}