package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Droppable;
import PaooGame.Items.DroppableFactory;
import PaooGame.Items.Goal;
import PaooGame.Items.Hero;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    private Goal level1;
    private ArrayList<Droppable> notes;
    private final DroppableFactory factory = new DroppableFactory();

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
        uiManager=new UIManager(refLink);
        uiManager.addObject(new UIImageButton(Assets.back, refLink.GetWidth()-210, refLink.GetHeight()-75, 100, 50) {
            @Override
            public void onClick() {
                State.SetState(refLink.GetGame().getMenuState());
            }
        });
            ///Construieste harta jocului
        map = new Map();
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
        restartGame();
    }

    private void restartGame() {
        if(notes!=null)
        {
            notes.clear();
        }
        else {
            notes = new ArrayList<>(6);
        }
        level1 = new Goal(Assets.lvl1sheet);
        level1.addTarget("Do");
        level1.addTarget("Re");
        level1.addTarget("Mi");
        level1.addTarget("Fa");
        level1.addTarget("Sol");
        level1.addTarget("La");
        level1.addTarget("Si");
        level1.addTarget("Do");
        for(int i=0; i<6; ++i)
        {
            Droppable note = factory.generate(refLink, refLink.getRNG(), refLink.getDifficulty());
            notes.add(note);
        }

        ///Construieste eroul
        hero = new Hero(refLink,440, 430);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override

    public void Update() {
            uiManager.Update();
            hero.Update();

            for (int i = 0; i < notes.size(); ++i) {
                Droppable note = notes.get(i);
                for (Droppable anotherNote : notes) {
                    if (note.getRectangle().intersects(anotherNote.getRectangle()) && anotherNote != note && anotherNote.getY() < 0) {
                        note.Init();
                        anotherNote.Init();
                    }
                }
                note.Update();
                if (hero.getRectangle().intersects(note.getRectangle())) {
                    if (note.getY() < hero.getY()) {
                        System.out.println("Got an intersection!");
                        System.out.println(note.getPayload());
                        if (note.getPayload().equalsIgnoreCase("Bomb")) {
                            hero.die();
                        } else if (note.getPayload().equalsIgnoreCase("Bonus")) {
                            hero.heal();
                            hero.grantPoints(100);
                        } else if (level1.isNeededPayload(note.getPayload())) {
                            hero.grantPoints(300);
                            if (level1.goalReached()) {
                                System.out.println("Game finished!");
                                State.SetState(refLink.GetGame().getMenuState());
                            }
                        } else {
                            hero.takeDamage();
                            hero.grantPoints(-50);
                        }
                        notes.set(i, factory.generate(refLink, refLink.getRNG(), refLink.getDifficulty()));
                    }
                    if (hero.isDead()) {
                        hero.grantPoints(hero.getHP() * 200);
                        System.out.println("KBOOM, URDEAD!");
                        refLink.GetGame().StopGame();
                    }
                }
                if (note.getY() > refLink.GetHeight() - 200) {
                    notes.set(i, factory.generate(refLink, refLink.getRNG(), refLink.getDifficulty()));
                }
            }
        }

    //}

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g) {

            map.Draw(g);
            hero.Draw(g);
            level1.Draw(g);
            for (Droppable note : notes) {
                note.Draw(g);
            }
            uiManager.Draw(g);
        }

    @Override
    public void resetState() {
        restartGame();
    }
}

