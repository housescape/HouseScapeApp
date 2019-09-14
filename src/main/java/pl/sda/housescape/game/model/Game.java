package pl.sda.housescape.game.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.sda.housescape.game.dao.GameEntity;

import java.util.List;

@Data
public class Game {

    private Long id;
    private String name;
    private List<GameStep> steps;


    public Game(String name) {
        this.name = name;
    }

    public Game(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
