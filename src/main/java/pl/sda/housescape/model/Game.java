package pl.sda.housescape.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Game {

    private String name;
    public Game(String name) {
        this.name = name;

    }
}
