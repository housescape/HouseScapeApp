package pl.sda.housescape.gameCreator;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.validation.Validator;

@Controller
@RequestMapping
public class GameController {
    private final GameService gameService;
    private final Validator newGameValidator;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(newGameValidator);
    }

    public GameController(GameService gameService, @Qualifier("newGameDTOValidator")
            Validator newGameValidtor) {
        this.gameService = gameService;
        this.newGameValidator = newGameValidtor;
    }

    @RequestMapping
    public ModelAndView getAdminGamePage() {return new ModelAndView("/admianGame/index");}

@RequestMapping("/games")
    public ModelAndView addGame(@ModelAttribute("newGame")
                                @Validated NewGameDTO newGameDTO, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           return new ModelAndView("adminGame/games");
       }
       gameService.addGame(newGameDTO);
       return new ModelAndView("redirect:/games");
}

}
