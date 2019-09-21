package pl.sda.housescape.game.service;

import org.springframework.stereotype.Service;
import pl.sda.housescape.game.dao.GameEntity;
import pl.sda.housescape.game.dao.GameRepository;
import pl.sda.housescape.game.dao.StepEntity;
import pl.sda.housescape.game.dao.StepRepository;
import pl.sda.housescape.game.model.Game;
import pl.sda.housescape.game.model.Status;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayGameService {

    private final GameRepository gameRepository;
    private final StepRepository stepRepository;

    public PlayGameService(GameRepository gameRepository, StepRepository stepRepository) {
        this.gameRepository = gameRepository;
        this.stepRepository = stepRepository;
    }

    public List<Game> getGamesToPlay() {
        return gameRepository.findAll()
                .stream()
                .filter(x -> x.getStatus().equals(Status.DONE))
                .map(GameEntity::toModel)
                .collect(Collectors.toList());
    }

    public Long findFirstIdStep() {
        return stepRepository.findAll()
                .stream()
                .findFirst()
                .get()
                .getId();
    }

    public boolean codeComparison(Long idStep, String inputCode) {
        String stepCode = (stepRepository
                .findAll().stream()
                .filter(x->x.getId().equals(idStep))
                .findFirst().get().getCode());
        return inputCode.equals(stepCode);
    }

    public Optional<Long> getNextStep(Long idGame, Long currentStep) {

        Optional<GameEntity> maybeGame = gameRepository.findById(idGame);
        if (!maybeGame.isPresent()) {
            throw new NoSuchElementException("Could not find game with id " + idGame);
        }
        GameEntity gameEntity = maybeGame.get();
        Set<StepEntity> steps = gameEntity.getSteps();
        ArrayList<StepEntity> stepsList = new ArrayList<>(steps);
        List<StepEntity> sortedSteps = stepsList.stream()
                .sorted(Comparator.comparing(StepEntity::getId))
                .collect(Collectors.toList());

        boolean currentFound = false;

        for (StepEntity step : sortedSteps) {
            if(currentFound) {
                return Optional.of(step.getId());
            }
            if(step.getId() == currentStep) {
                currentFound = true;
            }
        }
        return Optional.empty();
    }
}
