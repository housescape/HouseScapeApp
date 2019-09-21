package pl.sda.housescape.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.housescape.game.service.GameService;
import pl.sda.housescape.game.service.PlayGameService;
import pl.sda.housescape.game.service.StepService;

import java.util.Optional;


@Controller
@RequestMapping("/play")
public class PlayGameController {

    private final PlayGameService playGameService;
    private final GameService gameService;
    private final StepService stepService;

    public PlayGameController(PlayGameService playGameService, GameService gameService, StepService stepService) {
        this.playGameService = playGameService;
        this.gameService = gameService;
        this.stepService = stepService;
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
        mnv.addObject("game", gameService.editGame(idGame));
        mnv.addObject("stepList", stepService.getSteps(idGame));
        mnv.addObject("oneStep", stepService.getStep(idStep));
        mnv.addObject("nextStep", new StepForm());
        mnv.addObject("idStep", idStep);
        return mnv;
    }


    @PostMapping("/{idGame}/{idStep}")
    public ModelAndView nextStep(@PathVariable Long idGame, @PathVariable Long idStep,
                                 @ModelAttribute("nextStep") StepForm stepForm) {
        if (playGameService.codeComparison(idStep, stepForm.getCode())) {

            Optional<Long> nextStepMaybe = playGameService.getNextStep(idGame, idStep);
            if(!nextStepMaybe.isPresent()) {
                return new ModelAndView("redirect:/play/{idGame}/win");
            }
            return new ModelAndView("redirect:/play/{idGame}/" + nextStepMaybe.get());
        }
        return new ModelAndView("redirect:/play/{idGame}/{idStep}");
    }


}



