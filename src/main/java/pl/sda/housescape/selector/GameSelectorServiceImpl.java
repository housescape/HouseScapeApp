package pl.sda.housescape.selector;

import org.springframework.stereotype.Service;
import pl.sda.housescape.game.GameEntity;
import pl.sda.housescape.model.Game;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameSelectorServiceImpl implements GameSelectorService {

    @Override
    public List<Game> getGames() {
        List<Game> gamesList= new ArrayList<>();
//        gamesList.add(new Game());
//        gamesList.add(new Game());
//        gamesList.add(new Game());
return gamesList;
    }
}
