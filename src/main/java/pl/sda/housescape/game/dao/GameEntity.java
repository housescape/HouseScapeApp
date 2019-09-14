package pl.sda.housescape.game.dao;

import lombok.*;
import pl.sda.housescape.game.model.Game;
import pl.sda.housescape.game.model.Status;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "Game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Status status;

    public Game toModel() {
        return new Game(id, name, status);
    }
}
