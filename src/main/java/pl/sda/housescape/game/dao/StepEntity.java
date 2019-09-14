package pl.sda.housescape.game.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import pl.sda.housescape.game.model.GameStep;

import javax.persistence.*;

@AllArgsConstructor
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

    public GameStep toModel() {
         return new GameStep(id, description, code);
    }
}

