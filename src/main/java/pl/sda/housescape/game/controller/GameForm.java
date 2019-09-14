package pl.sda.housescape.game.controller;

import lombok.Data;

@Data
public class GameForm {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
