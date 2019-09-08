package pl.sda.housescape.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Game {

    private int id;
    private String name;

    public Game(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
