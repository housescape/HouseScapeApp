package pl.sda.housescape.game.controller;

import lombok.Data;
import pl.sda.housescape.game.model.GameStep;

@Data
public class StepForm {

    private Long id;
    private String description;
    private String code;
    private GameStep nexStep;

}
