package pl.sda.housescape.game.service;

import org.springframework.stereotype.Service;
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
public class PlayGameService {

    private final GameRepository repository;
    private final StepRepository stepRepository;

    public PlayGameService(GameRepository repository, StepRepository stepRepository) {
        this.repository = repository;
        this.stepRepository = stepRepository;
    }

    public List<Game> getGamesToPlay() {
        return repository.findAll()
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


}
