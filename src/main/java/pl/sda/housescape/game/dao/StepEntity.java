package pl.sda.housescape.game.dao;

import lombok.*;
import pl.sda.housescape.game.model.Game;
import pl.sda.housescape.game.model.GameStep;

import javax.persistence.*;
import javax.persistence.SequenceGenerator;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "step-id-generator")
    @SequenceGenerator(name = "step-id-generator", sequenceName = "stepId",allocationSize = 50)
    private Long id;
    private String description;
    private String code;

    @ManyToOne
    private GameEntity gameEntity;

    public GameStep toModel() {
         return new GameStep(id, description, code);
    }
}

