package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Settings.Difficulty;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;

/*! \class public class SettingsState extends State
    \brief Implementeaza notiunea de settings pentru joc.

    Aici setarile vor trebui salvate/incarcate intr-un/dintr-un fisier/baza de date sqlite.
 */
public class SettingsState extends State
{
    /*! \fn public SettingsState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public SettingsState(RefLinks refLink)
    {
            ///Apel al construcotrului clasei de baza.
            super(refLink);
            uiManager=new UIManager(refLink);
            uiManager.addObject(new UIImageButton(Assets.back, refLink.GetWidth()-150, refLink.GetHeight()-100, 100, 50) {
                @Override
                public void onClick() {
                    State.SetState(refLink.GetGame().getMenuState());
                }
            });
            uiManager.addObject(new UIImageButton(Assets.easy, refLink.GetWidth()/2-60, 150, 120, 50) {
                @Override
                public void onClick() {
                    refLink.setDifficulty(Difficulty.EASY);
                    State.SetState(refLink.GetGame().getMenuState());
                }
            });
            uiManager.addObject(new UIImageButton(Assets.medium, refLink.GetWidth()/2-75, 300, 150, 50) {
                @Override
                public void onClick() {
                    refLink.setDifficulty(Difficulty.MEDIUM);
                    State.SetState(refLink.GetGame().getMenuState());
                }
            });
            uiManager.addObject(new UIImageButton(Assets.hard, refLink.GetWidth()/2-60, 450, 120, 50)
            {
                @Override
                public void onClick()
                {
                    refLink.setDifficulty(Difficulty.HARD);
                    State.SetState(refLink.GetGame().getMenuState());
                }
            });
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea setarilor.
     */
    @Override
    public void Update()
    {
        uiManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        uiManager.Draw(g);
        g.setFont(Assets.font);
        FontMetrics metrics = g.getFontMetrics(Assets.font);
        // Determine the X coordinate for the text
        int str_x = refLink.GetWidth()/2 - metrics.stringWidth("Choose difficulty : ") / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int str_y = refLink.GetHeight()/8 - metrics.getHeight() / 2 + metrics.getAscent();
        g.drawString("Choose difficulty : ", str_x, str_y);
    }

    @Override
    public void resetState() {
        
    }
}
