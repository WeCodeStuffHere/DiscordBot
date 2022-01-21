package WeCodeStuffHere.modules;

import WeCodeStuffHere.database.models.Player;
import WeCodeStuffHere.modules.annotations.DatabaseConnection;
import WeCodeStuffHere.modules.annotations.PlayerDAO;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseModule extends AbstractModule {
    private ConnectionSource connectionSource;

    public DatabaseModule() {
        super();

        try {
            String databaseUrl = "jdbc:mysql://db:3306/wecodestuffhere";
            connectionSource = new JdbcConnectionSource(databaseUrl,"wecodestuffhere","gayqueens");

            TableUtils.createTableIfNotExists(connectionSource, Player.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Provides
    @DatabaseConnection
    ConnectionSource providesDatabaseConnection() {
        return connectionSource;
    }

    protected void configure() {
        try {
            TypeLiteral<Dao<Player, String>> neighbourDAOType = new TypeLiteral<>() {};

            bind(neighbourDAOType).annotatedWith(PlayerDAO.class).toInstance(DaoManager.createDao(connectionSource, Player.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
