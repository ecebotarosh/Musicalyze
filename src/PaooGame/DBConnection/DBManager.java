package PaooGame.DBConnection;


import PaooGame.RefLinks;
import PaooGame.Settings.Difficulty;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class DBManager {

    private RefLinks refLinks;
    private String src;
    private ConnectionSource connection;
    private Dao<DifficultyTable, Long> difficultyTableDao;
    private Dao<GameTable, Long> gameTableDao;


    public DBManager(RefLinks refLinks, String connectionString){
        this.refLinks = refLinks;
        this.src=connectionString;
        try {
            connection = new JdbcConnectionSource(src);
            TableUtils.createTableIfNotExists(connection, DifficultyTable.class);
            TableUtils.createTableIfNotExists(connection, GameTable.class);
            difficultyTableDao = DaoManager.createDao(connection, DifficultyTable.class);
            gameTableDao = DaoManager.createDao(connection, GameTable.class);
            if(difficultyTableDao.queryForAll().size()!=3)
            {
                difficultyTableDao.delete(difficultyTableDao.queryForAll());
                DifficultyTable easy = new DifficultyTable();
                easy.setIdDifficulty(1);
                easy.setType("Easy");
                DifficultyTable medium = new DifficultyTable();
                medium.setIdDifficulty(2);
                medium.setType("Medium");
                DifficultyTable hard = new DifficultyTable();
                hard.setIdDifficulty(3);
                hard.setType("Hard");
                difficultyTableDao.createIfNotExists(easy);
                difficultyTableDao.createIfNotExists(medium);
                difficultyTableDao.createIfNotExists(hard);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void initializeGame() {
        try {
            if (gameTableDao.queryForAll().isEmpty()) {
                generateNewGame();
            }
            else
            {
                gameTableDao.delete(gameTableDao.queryForAll());
                generateNewGame();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void generateNewGame() throws SQLException {
        GameTable newGame = new GameTable();
        DifficultyTable medium = difficultyTableDao.queryForId((long) 2);
        newGame.setDifficulty(medium);
        gameTableDao.create(newGame);
        refLinks.setGameInTable(newGame);
        System.out.println("New Game set");
        System.out.println(newGame);
    }


    public void changeDifficulty(Difficulty difficulty) {
        try {
            GameTable game = gameTableDao.queryForId(refLinks.getGameInTableId());
            if (game != null) {
                switch (difficulty) {
                    case EASY:
                        try {
                            game.setDifficulty(difficultyTableDao.queryForId((long) 1));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            gameTableDao.update(game);
                            break;
                        }
                    case MEDIUM:
                        try {
                            game.setDifficulty(difficultyTableDao.queryForId((long) 2));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            gameTableDao.update(game);
                            break;
                        }
                    case HARD:
                        try {
                            game.setDifficulty(difficultyTableDao.queryForId((long) 3));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            gameTableDao.update(game);
                            break;
                        }
                }
            } else {
                game = new GameTable();
                try {
                    game.setDifficulty(difficultyTableDao.queryForId((long) 2));
                    gameTableDao.create(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
