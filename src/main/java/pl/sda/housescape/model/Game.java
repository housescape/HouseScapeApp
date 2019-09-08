package pl.sda.housescape.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
public class Game {

    private int id;
    private String name;
    private List<GameStep> steps;


    public Game(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
