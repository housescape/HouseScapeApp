package pl.sda.housescape.game.model;

import java.util.List;

public class GameStep {

    private Long id;
    private String description;
    private String unblockCode;

    public GameStep(Long id, String description, String unblockCode) {
        this.id = id;
        this.description = description;
        this.unblockCode = unblockCode;
    }
}
