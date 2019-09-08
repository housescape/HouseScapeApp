package pl.sda.housescape.creator;



public interface GameCreatorService {
    void addGame(NewGameCreatorDTO newGame);

    void remove(long idGame);

    GameCreatorDTO getGamesById(long idGame)
            throws Exception;

}
