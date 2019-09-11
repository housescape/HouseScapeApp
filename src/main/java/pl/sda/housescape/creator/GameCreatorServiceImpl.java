package pl.sda.housescape.creator;

import org.springframework.stereotype.Service;
import pl.sda.housescape.game.GameEntity;
import pl.sda.housescape.game.GameMapper;
import pl.sda.housescape.game.GameRepository;
import pl.sda.housescape.model.Game;
import pl.sda.housescape.model.NewGame;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameCreatorServiceImpl implements GameCreatorService{

    private final GameRepository repository;

    public GameCreatorServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addGame(NewGame newGame) {
         GameEntity gameEntity = GameEntity
                 .builder()
                 .name(newGame.getName())
                 .build();
         repository.save(gameEntity);
    }

    @Override
    public List<Game> getGame() {
        return repository.findAll()
                .stream()
                .map(GameMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(long idGame) {

    }
}
