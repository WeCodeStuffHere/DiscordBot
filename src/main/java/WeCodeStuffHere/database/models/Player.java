package WeCodeStuffHere.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "player")
public class Player {
    @DatabaseField(canBeNull = false, id = true, columnName = "name")
    private String name;

    @DatabaseField(canBeNull = false, columnName = "experience")
    private float experience;

    @DatabaseField(canBeNull = false, columnName = "level")
    private int level;

    // ORMLite requires a no-arg constructor.
    public Player() {}

    public Player(String name, float experience, int level) {
        this.name = name;
        this.experience = experience;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public float getExperience() {
        return experience;
    }
    public int getLevel() {
        return level;
    }
    public void setExperience(float experience) {
        this.experience = experience;
    }
}
