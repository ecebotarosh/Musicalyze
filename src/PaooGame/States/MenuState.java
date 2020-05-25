package PaooGame.States;

import PaooGame.RefLinks;

import javax.swing.*;
import java.awt.*;


/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    JPanel container;
    JButton newGame;
    JButton loadGame;
    JButton settings;
    JButton about;
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        container = new JPanel();
        container.setLayout(null);
        container.setPreferredSize(new Dimension(refLink.GetWidth(), refLink.GetHeight()));
        newGame = new JButton("New Game");
        loadGame = new JButton("Load Game");
        settings = new JButton("Settings");
        about = new JButton("Load Game");
        newGame.setVisible(true);
        loadGame.setVisible(true);
        settings.setVisible(true);
        about.setVisible(true);
        newGame.setBounds(100, 100, 150, 150);
        loadGame.setBounds(100, 200, 150, 150);
        settings.setBounds(100, 300, 150, 150);
        about.setBounds(100, 400, 150, 150);
        newGame.setOpaque(false);
        loadGame.setOpaque(false);
        settings.setOpaque(false);
        about.setOpaque(false);
        newGame.setBorderPainted(false);
        loadGame.setBorderPainted(false);
        settings.setBorderPainted(false);
        about.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        loadGame.setContentAreaFilled(false);
        about.setContentAreaFilled(false);
        settings.setContentAreaFilled(false);
        newGame.setFocusPainted(true);
        loadGame.setFocusPainted(true);
        settings.setFocusPainted(true);
        about.setFocusPainted(true);
        newGame.addActionListener(ActionListener -> System.out.println("We mizerie"));
        addButtons();
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        System.out.println(refLink.GetMouseManager().getMouseX() +  " " + refLink.GetMouseManager().getMouseY());
        if(refLink.GetMouseManager().isLeftPressed() && refLink.GetMouseManager().isRightPressed())
        {
            State.SetState(refLink.GetGame().getPlayState());
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
       /* refLink.GetGame().getWnd().GetWndFrame();
        newGame.paint(g);
        loadGame.paint(g);
        settings.paint(g);
        about.paint(g);*/

        //container.paint(g);
        g.setColor(Color.RED);
        g.fillRect(refLink.GetMouseManager().getMouseX(), refLink.GetMouseManager().getMouseY(), 64, 64);
    }

    public void addButtons()
    {
        container.add(newGame);
        container.add(loadGame);
        container.add(settings);
        container.add(about);
        refLink.GetGame().getWnd().GetWndFrame().getContentPane().add(container);
        /*refLink.GetGame().getWnd().GetWndFrame().add(newGame);
        refLink.GetGame().getWnd().GetWndFrame().add(loadGame);
        refLink.GetGame().getWnd().GetWndFrame().add(settings);
        refLink.GetGame().getWnd().GetWndFrame().add(about);*/
    }

    public void removeButtons()
    {
        refLink.GetGame().getWnd().GetWndFrame().getContentPane().remove(container);
    }
}
