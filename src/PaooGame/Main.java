package PaooGame;

import PaooGame.GameWindow.GameWindow;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = new Game("Musicalyze", 1024, 640);
        paooGame.StartGame();
    }
}
