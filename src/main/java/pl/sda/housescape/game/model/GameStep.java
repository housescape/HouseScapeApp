package pl.sda.housescape.game.model;

import lombok.Data;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Data
public class GameStep {


    private Long id;
    private String description;
    private String code;





    public GameStep(Long id, String description, String code) {
        this.id = id;
        this.description = description;
        this.code = code;
    }
}
