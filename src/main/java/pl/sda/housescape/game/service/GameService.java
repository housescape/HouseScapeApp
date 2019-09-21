package pl.sda.housescape.game.service;

import org.springframework.stereotype.Service;
import pl.sda.housescape.game.controller.GameForm;
import pl.sda.housescape.game.dao.GameEntity;
import pl.sda.housescape.game.dao.GameRepository;
import pl.sda.housescape.game.model.Game;
import pl.sda.housescape.game.model.Status;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;

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
    public List<Game> getGames() {
        return repository.findAll()
                .stream()
                .map(GameEntity::toModel)
                .collect(Collectors.toList());
    }

    public GameEntity editGame(long id) {
        GameEntity game = repository.findAll().stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
        return game;
    }

    public void removeGame(long id) {
        repository.deleteById(id);
    }

}
