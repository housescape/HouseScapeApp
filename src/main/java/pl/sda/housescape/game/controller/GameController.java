package pl.sda.housescape.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/{idGame}")
    public ModelAndView editGame(@PathVariable long idGame) {
        ModelAndView mnv = new ModelAndView("edit");
        mnv.addObject("images", imageStorageService.getImages());
        mnv.addObject("game", gameService.editGame(idGame));
        return mnv;
    }

    @RequestMapping("/delete/{idGame}")
    public ModelAndView deleteGame(@PathVariable long idGame) {
        gameService.remove(idGame);
        return new ModelAndView("redirect:/game");
    }
    
}