package pl.sda.housescape.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import pl.sda.housescape.steps.Image;

@AllArgsConstructor
public class GameStep {

    private Image image;
    private String description;
    private String code;



}
