package pl.sda.housescape.game;
import lombok.*;
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
}
