package pl.sda.housescape.game.dao;
import lombok.*;
import pl.sda.housescape.game.model.Game;

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

    public Game toModel() {
        return new Game(id, name);
    }
}
