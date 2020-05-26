package PaooGame.DBConnection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Game")
public class GameTable {

    @DatabaseField(generatedId = true, columnName = "id")
    private Long gameId;

    @DatabaseField(foreign=true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private DifficultyTable difficulty;

    public GameTable()
    {

    }

    public void setDifficulty(DifficultyTable difficulty) {
        this.difficulty = difficulty;
    }

    public DifficultyTable getDifficulty() {
        return difficulty;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
