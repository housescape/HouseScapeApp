package pl.sda.housescape.game.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.sda.housescape.game.dao.GameEntity;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode
public class Game {

    private Long id;
    private String name;
    private Status status;



    public Game(String name) {
        this.name = name;
    }

    public Game(Long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;

    }
}
