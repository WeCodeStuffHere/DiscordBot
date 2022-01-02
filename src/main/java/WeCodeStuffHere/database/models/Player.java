package WeCodeStuffHere.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "player")
public class Player {
    @DatabaseField(canBeNull = false, id = true, columnName = "name")
    private String name;

    @DatabaseField(canBeNull = false, columnName = "experience")
    private float experience;

    // ORMLite requires a no-arg constructor.
    public Player() {}

    public Player(String name, float experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public float getExperience() {
        return experience;
    }
}
