package pl.sda.housescape.creator;


import org.springframework.stereotype.Service;


public interface GameCreatorService {
    void addGame(NewGameCreatorDTO newGame);

    void remove(long idGame);



}
