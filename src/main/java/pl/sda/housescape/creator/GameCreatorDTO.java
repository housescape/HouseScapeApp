package pl.sda.housescape.creator;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GameCreatorDTO {
    private long id;
    private String name;

    public GameCreatorDTO(GameCreatorEntity gameCreatorEntity) {
        this.id = gameCreatorEntity.getId();
        this.name = gameCreatorEntity.getName();
    }
}
