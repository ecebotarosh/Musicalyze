package PaooGame;

import PaooGame.DBConnection.DBManager;
import PaooGame.DBConnection.GameTable;
import PaooGame.Input.KeyManager;
import PaooGame.Input.MouseManager;
import PaooGame.Maps.Map;
import PaooGame.Settings.Difficulty;

import java.util.Random;

/*! \class public class RefLinks
    \brief Clasa ce retine o serie de referinte ale unor elemente pentru a fi usor accesibile.

    Altfel ar trebui ca functiile respective sa aiba o serie intreaga de parametri si ar ingreuna programarea.
 */
public class RefLinks
{
    private Game game;          /*!< Referinta catre obiectul Game.*/
    private Map map;            /*!< Referinta catre harta curenta.*/
    private Difficulty difficulty;
    private GameTable gameTable;
    private DBManager dbManager;

    private Random r;

    /*! \fn public RefLinks(Game game)
        \brief Constructorul de initializare al clasei.

        \param game Referinta catre obiectul game.
     */
    public RefLinks(Game game, String connectionString)
    {
        this.game = game;
        dbManager = new DBManager(this, connectionString);
        difficulty = Difficulty.MEDIUM;
        dbManager.initializeGame();
        r = new Random(System.currentTimeMillis());
    }

    /*! \fn public KeyManager GetKeyManager()
        \brief Returneaza referinta catre managerul evenimentelor de tastatura.
     */
    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }

    public MouseManager GetMouseManager() { return game.GetMouseManager(); }

    /*! \fn public int GetWidth()
        \brief Returneaza latimea ferestrei jocului.
     */
    public int GetWidth()
    {
        return game.GetWidth();
    }

    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei jocului.
     */
    public int GetHeight()
    {
        return game.GetHeight();
    }

    /*! \fn public Game GetGame()
        \brief Intoarce referinta catre obiectul Game.
     */
    public Game GetGame()
    {
        return game;
    }

    /*! \fn public void SetGame(Game game)
        \brief Seteaza referinta catre un obiect Game.

        \param game Referinta obiectului Game.
     */
    public void SetGame(Game game)
    {
        this.game = game;
    }

    /*! \fn public Map GetMap()
        \brief Intoarce referinta catre harta curenta.
     */
    public Map GetMap()
    {
        return map;
    }

    /*! \fn public void SetMap(Map map)
        \brief Seteaza referinta catre harta curenta.

        \param map Referinta catre harta curenta.
     */
    public void SetMap(Map map)
    {
        this.map = map;
    }

    public Random getRNG()
    {
        return this.r;
    }

    public void setDifficulty(Difficulty difficulty) {
        dbManager.changeDifficulty(difficulty);
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    public GameTable getGameInTable() {
        return gameTable;
    }

    public void setGameInTable(GameTable gameTable) {
        this.gameTable = gameTable;
    }

    public Long getGameInTableId()
    {
        return gameTable.getGameId();
    }
}
