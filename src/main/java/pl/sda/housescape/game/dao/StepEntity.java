package pl.sda.housescape.game.dao;

import lombok.*;
import pl.sda.housescape.game.model.Game;
import pl.sda.housescape.game.model.GameStep;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "Steps")
public class StepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String code;

    @ManyToOne
    private GameEntity gameEntity;

    public GameStep toModel() {
         return new GameStep(id, description, code);
    }
}

