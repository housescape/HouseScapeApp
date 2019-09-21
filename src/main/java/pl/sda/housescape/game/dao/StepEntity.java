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
    private String imageUrl;

    @Column(name = "game_entity_id")
    private Long gameId;

    public static StepEntity create(String description, String code, String imageUrl) {
        StepEntity entity = new StepEntity();
        entity.setDescription(description);
        entity.setCode(code);
        entity.setImageUrl(imageUrl);
        return entity;
    }
    public GameStep toModel() {
         return new GameStep(id, description, code, imageUrl);
    }
}

