package pl.sda.housescape.creator;

import org.springframework.stereotype.Service;

@Service
public class GameCreatorImpl implements GameCreatorService {
    @Override
    public void addGame(NewGameCreatorDTO newGame) {
    }

    @Override
    public void remove(long idGame) {
    }

    @Override
    public GameCreatorDTO getGamesById(long idGame) throws Exception {
        return null;
    }
}
