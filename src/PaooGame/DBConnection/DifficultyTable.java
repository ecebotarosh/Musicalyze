package PaooGame.DBConnection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Difficulty")
public class DifficultyTable {

    @DatabaseField(generatedId = true, columnName="idDifficulty")
    private long idDifficulty;

    @DatabaseField(canBeNull = false, columnName="Type")
    private String type;

    public DifficultyTable()
    {

    }

    public DifficultyTable(String type)
    {
        this.type=type;
    }

    public long getIdDifficulty() {
        return idDifficulty;
    }

    public String getType() {
        return type;
    }

    public void setIdDifficulty(long idDifficulty) {
        this.idDifficulty = idDifficulty;
    }

    public void setType(String type) {
        this.type = type;
    }
}
