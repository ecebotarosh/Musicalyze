package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private final int maxHP=3;
    private int HP;
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private ArrayList<BufferedImage> displayedHP;
    private int score;
    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {

            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Assets.accordeon.getWidth()/4, Assets.accordeon.getHeight()/4);
            ///Seteaza imaginea de start a eroului
        image = Assets.accordeon;
        displayedHP = new ArrayList<>();
        for(int i=0; i<maxHP; ++i)
        {
            displayedHP.add(Assets.fullHP);
        }
        HP=maxHP;
        score=0;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        Move();
        for(int i=0; i<maxHP; ++i)
        {
            if(i<HP) {
                displayedHP.set(i, Assets.fullHP);
            }
            else
            {
                displayedHP.set(i, Assets.damagedHP);
            }
        }
            ///Actualizeaza imaginea
/*        if(refLink.GetKeyManager().left == true)
        {
            image = Assets.heroLeft;
        }
        if(refLink.GetKeyManager().right == true) {
            image = Assets.heroRight;
        }*/
    }

    public boolean isDead()
    {
        return this.HP==0;
    }

    public void takeDamage()
    {
        --this.HP;
    }

    public void heal()
    {
        if((!isDead()) && this.HP<maxHP) ++this.HP;
    }

    public void grantPoints(int amount)
    {
        this.score+=amount;
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
            ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
        }
            ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null);
        for(int i=0; i<maxHP; ++i)
        {
            g.drawImage(displayedHP.get(i), 50+i*50, 570, displayedHP.get(i).getWidth()/4, displayedHP.get(i).getHeight()/4, null);
        }
        g.setFont(Assets.font);
        // Determine the X coordinate for the text
        int str_x = 800;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        //int str_y = (int)y + ((image.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        int str_y = 550;
        g.drawString("Score : " + score, str_x, str_y);
            ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        /*g.setColor(Color.blue);
        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);*/
    }

    public int getY()
    {
        return (int)this.y;
    }

    public void die()
    {
        this.HP=0;
    }

    public Rectangle getRectangle()
    {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public int getHP()
    {
        return this.HP;
    }

    public int getScore()
    {
        return this.score;
    }

    public void setHP(int hp)
    {
        this.HP=hp;
    }

    public void setScore(int score)
    {
        this.score=score;
    }

}
