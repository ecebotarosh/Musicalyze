package PaooGame;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = new Game("Musicalyze", 1024, 640);
        paooGame.StartGame();
        String dbUrl ="jdbc:sqlite:db/Musicalyze.db";

        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(dbUrl);
            connectionSource.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
