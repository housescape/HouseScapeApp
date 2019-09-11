package pl.sda.housescape.game;

import pl.sda.housescape.model.Game;
import pl.sda.housescape.model.NewGame;

public class GameMapper {

    public static Game map(GameEntity gameEntity) {
        return new Game(gameEntity);
    }
}
