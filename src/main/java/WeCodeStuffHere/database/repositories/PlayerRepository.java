package WeCodeStuffHere.database.repositories;

import WeCodeStuffHere.database.models.Player;
import WeCodeStuffHere.modules.annotations.PlayerDAO;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class PlayerRepository {
    private final Dao<Player, String> playerDAO;

    @Inject
    public PlayerRepository(@PlayerDAO Dao<Player, String> playerDAO) {
        this.playerDAO = playerDAO;
    }

    public synchronized List<Player> getAllPlayers() {
        try {
            return playerDAO.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createPlayer(String name, float experience) {
        this.createPlayer(new Player(name, experience));
    }

    public void createPlayer(Player player) {
        try {
            playerDAO.createOrUpdate(player);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized Player getPlayer(String name) {
        Player player = null;
        try {
            List<Player> players = playerDAO.queryBuilder()
                    .where().eq("name", name).query();

            player = players.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return player;
    }
}
