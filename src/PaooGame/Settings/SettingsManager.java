package PaooGame.Settings;

import PaooGame.Input.KeyManager;

public class SettingsManager {
    private boolean gamePaused;
    private KeyManager manager;
    public SettingsManager()
    {
        gamePaused=false;
    }

    public void switchPauseState()
    {
        gamePaused=(!gamePaused);
    }

    public void setManager(KeyManager manager)
    {
        this.manager=manager;
    }

    public KeyManager getManager()
    {
        return this.manager;
    }

    public boolean isGamePaused()
    {
        return this.gamePaused;
    }


    public void getInput()
    {
        if(manager.pause)
        {
            switchPauseState();
        }
    }

    public void Update()
    {
        getInput();
    }

}
