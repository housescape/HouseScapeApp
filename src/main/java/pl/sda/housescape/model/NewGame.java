package pl.sda.housescape.model;

import lombok.Data;

@Data
public class NewGame {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
