package pl.sda.housescape.game.service;

import org.springframework.stereotype.Service;
import pl.sda.housescape.game.controller.GameForm;
import pl.sda.housescape.game.controller.StepForm;
import pl.sda.housescape.game.dao.GameEntity;
import pl.sda.housescape.game.dao.GameRepository;
import pl.sda.housescape.game.dao.StepEntity;
import pl.sda.housescape.game.dao.StepRepository;
import pl.sda.housescape.game.model.Game;
import pl.sda.housescape.game.model.GameStep;
import pl.sda.housescape.game.model.Status;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository repository;
    private final StepRepository stepRepository;

    public GameService(GameRepository repository, StepRepository stepRepository) {
        this.repository = repository;
        this.stepRepository = stepRepository;
    }

    public void done(long idGame) {
        GameEntity gameEntity = repository.findAll().stream().filter(x -> x.getId().equals(idGame)).findFirst().orElse(null);
        gameEntity.setStatus(Status.DONE);
        repository.save(gameEntity);
    }

    public void building(long idGame) {
        GameEntity gameEntity = repository.findAll().stream().filter(x -> x.getId().equals(idGame)).findFirst().orElse(null);
        gameEntity.setStatus(Status.BILDING);
        repository.save(gameEntity);
    }

    public void addGame(GameForm gameForm) {
        GameEntity gameEntity = GameEntity
                .builder()
                .name(gameForm.getName())
                .status(Status.BILDING)
                .build();
        repository.save(gameEntity);
    }

    public void addStep(StepForm stepForm, Long idGame) {
        StepEntity stepEntity = StepEntity
                .builder()
                .code(stepForm.getCode())
                .description(stepForm.getDescription())
                .gameEntity(repository.findAll().stream().filter(x -> x.getId().equals(idGame)).findFirst().orElse(null))
                .build();
        stepRepository.save(stepEntity);
    }


    public List<Game> getGames() {
        return repository.findAll()
                .stream()
                .map(GameEntity::toModel)
                .collect(Collectors.toList());
    }

    public List<GameStep> getSteps(Long idGame) {
        GameEntity gameEntity = repository.findAll().stream().filter(x -> x.getId().equals(idGame)).findFirst().orElse(null);
        return stepRepository.findAll()
                .stream()
                .filter(x -> x.getGameEntity().equals(gameEntity))
                .map(StepEntity::toModel)
                .collect(Collectors.toList());
    }

    public GameStep getStep(Long idStep) {
        return stepRepository.findAll()
                .stream()
                .filter(x -> x.getId().equals(idStep))
                .map(StepEntity::toModel)
                .findFirst().orElse(null);
    }

    public void removeGame(long id) {
        List<StepEntity> listOfStepsToRemove = stepRepository.findAll().stream().filter(x -> x.getGameEntity().getId().equals(id)).collect(Collectors.toList());
        for (StepEntity step : listOfStepsToRemove ){
            stepRepository.delete(step);
        }

        GameEntity game = repository.findAll().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        repository.delete(game);

    }

    public void removeStep(long id) {
        StepEntity step = stepRepository.findAll().stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
        stepRepository.delete(step);
    }


    public GameEntity editGame(long id) {
        GameEntity game = repository.findAll().stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
        return game;
    }

    public void editStep(StepForm stepForm, long idStep) {
        StepEntity stepEntity = stepRepository.findAll().stream().filter(x -> x.getId().equals(idStep)).findFirst().orElse(null);
        stepEntity.setCode(stepForm.getCode());
        stepEntity.setDescription(stepForm.getDescription());
        stepRepository.save(stepEntity);
    }
}
