package PaooGame;

public class Main
{
    public static void main(String[] args)
    {
        String dbUrl ="jdbc:sqlite:res/db/test.db";
        Game paooGame = new Game("Musicalyze", 1024, 640, dbUrl);
        paooGame.StartGame();

    }
}
