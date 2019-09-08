package pl.sda.housescape.selector;

import org.springframework.stereotype.Service;
import pl.sda.housescape.model.Game;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameSelectorServiceImpl implements GameSelectorService {

    @Override
    public List<Game> getGames() {
        List<Game> gamesList= new ArrayList<>();
        gamesList.add(new Game(1, "OgródRod"));
        gamesList.add(new Game(2, "PodwórkoBabci"));
        gamesList.add(new Game(3, "DziałkaBłażeja"));
return gamesList;
    }
}
