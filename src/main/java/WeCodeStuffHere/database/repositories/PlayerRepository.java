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

    public void createPlayer(String name, float experience, int level) {
        this.createPlayer(new Player(name, experience, level));
    }

    public Player createPlayer(Player player) {
        try {
            playerDAO.createOrUpdate(player);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    public boolean ifExists(String name) {
        try {
            return playerDAO.idExists(name);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}


    public float getExperience(String name) {
        try {
            return  playerDAO.queryForId(name).getExperience();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void  setExperience(String name, float experience) {
        try {
            List<Player> player = playerDAO.queryBuilder().where().eq("name", name).query();
            player.get(0).setExperience(experience);
            playerDAO.createOrUpdate(createPlayer(new Player(player.get(0).name, experience, player.get(0).level)));

        } catch (SQLException e) {
            e.printStackTrace();

        }}

    public void setLevel(int level, String name) {
        try {
            List<Player> player = playerDAO.queryBuilder().where().eq("name", name).query();
            player.get(0).setLevel(level);
            playerDAO.createOrUpdate(createPlayer(new Player(player.get(0).name, level, player.get(0).level)));

        } catch (SQLException e) {
            e.printStackTrace();

        }}


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
    public int getLevel(String name) {
        try {
            return playerDAO.queryForId(name).getLevel();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}


