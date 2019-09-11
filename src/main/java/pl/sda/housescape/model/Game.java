package pl.sda.housescape.model;

import lombok.Getter;
import lombok.Setter;
import pl.sda.housescape.game.GameEntity;

import java.util.List;

@Getter
@Setter
public class Game {

    private Long id;
    private String name;
    private List<GameStep> steps;


    public Game(GameEntity gameEntity) {
        this.id = id;
        this.name = name;
    }
}
