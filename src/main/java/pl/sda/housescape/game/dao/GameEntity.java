package pl.sda.housescape.game.dao;

import lombok.*;
import org.hibernate.annotations.Cascade;
import pl.sda.housescape.game.model.Game;
import pl.sda.housescape.game.model.GameStep;
import pl.sda.housescape.game.model.Status;

import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game-id-generator")
    @SequenceGenerator(name = "game-id-generator", sequenceName = "gameId", allocationSize = 50)
    private Long id;

    private String name;
    private Status status;

    @OneToMany(mappedBy = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL) //kaskadowanie usuwa dzieci
    private Set<StepEntity> steps;

    public Game toModel() {
        return new Game(id, name, status);
    }
}
