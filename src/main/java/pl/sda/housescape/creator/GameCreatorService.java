package pl.sda.housescape.creator;

import pl.sda.housescape.model.Game;
import pl.sda.housescape.model.NewGame;

import java.util.List;

public interface GameCreatorService {

    void addGame(NewGame newGame);
    List<Game> getGame();
    void remove(long idGame);
   // Game getGameById(long idGame) throws NotFoundProductException;

}
