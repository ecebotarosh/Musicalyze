package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;


/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        uiManager=new UIManager(refLink);
        uiManager.addObject(new UIImageButton(Assets.newGame, refLink.GetWidth()/2-75, 100, 150, 50) {
            @Override
            public void onClick() {
                System.out.println("Clicked new game");
                refLink.GetGame().getPlayState().resetState();
                State.SetState(refLink.GetGame().getPlayState());
            }
        });
        uiManager.addObject(new UIImageButton(Assets.loadGame, refLink.GetWidth()/2-75, 200, 150, 50) {
            @Override
            public void onClick() {
                System.out.println("Clicked load game");

                State.SetState(refLink.GetGame().getPlayState());

            }
        });

        uiManager.addObject(new UIImageButton(Assets.settings, refLink.GetWidth()/2-75, 300, 150, 50) {
            @Override
            public void onClick() {
                State.SetState(refLink.GetGame().getSettingsState());
                System.out.println("Clicked settings");
            }
        });

        uiManager.addObject(new UIImageButton(Assets.about, refLink.GetWidth()/2-55, 400, 110, 50) {
            @Override
            public void onClick() {
                System.out.println("Clicked about");
                State.SetState(refLink.GetGame().getAboutState());
            }
        });

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        uiManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        uiManager.Draw(g);
    }

    @Override
    public void resetState() {

    }


}
