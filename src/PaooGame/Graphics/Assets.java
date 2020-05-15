package PaooGame.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage heroLeft;
    public static Font font = new Font("Arial Black", Font.BOLD, 20);
    public static BufferedImage heroRight;
    public static BufferedImage soil;
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage townGrass;
    public static BufferedImage townGrassDestroyed;
    public static BufferedImage townSoil;
    public static BufferedImage water;
    public static BufferedImage rockUp;
    public static BufferedImage rockDown;
    public static BufferedImage rockLeft;
    public static BufferedImage rockRight;
    public static BufferedImage tree;
    public static BufferedImage accordeon;
    public static BufferedImage background;
    public static BufferedImage lvl1sheet;
    public static BufferedImage bubble;
    public static BufferedImage fullHP;
    public static BufferedImage damagedHP;
    public static BufferedImage bomb;
    public static BufferedImage bonus;
    public static ArrayList<String> possiblePayloads = new ArrayList<>();
    public static ArrayList<String> possibleNotePayloads = new ArrayList<>();



    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass = sheet.crop(0, 0);
        soil = sheet.crop(1, 0);
        water = sheet.crop(2, 0);
        mountain = sheet.crop(3, 0);
        townGrass = sheet.crop(0, 1);
        townGrassDestroyed = sheet.crop(1, 1);
        townSoil = sheet.crop(2, 1);
        tree = sheet.crop(3, 1);
        heroLeft = sheet.crop(0, 2);
        heroRight = sheet.crop(1, 2);
        rockUp = sheet.crop(2, 2);
        rockDown = sheet.crop(3, 2);
        rockLeft = sheet.crop(0, 3);
        rockRight = sheet.crop(1, 3);

        accordeon = ImageLoader.LoadImage("/textures/accordeon.png");
        background = ImageLoader.LoadImage("/textures/bg.png");
        lvl1sheet = ImageLoader.LoadImage("/textures/lvl1.png");
        bubble = ImageLoader.LoadImage("/textures/bubble.png");
        fullHP = ImageLoader.LoadImage("/textures/fullHeart.png");
        damagedHP = ImageLoader.LoadImage("/textures/emptyHeart.png");
        bomb = ImageLoader.LoadImage("/textures/testbomb.png");
        bonus = ImageLoader.LoadImage("/textures/bonus.png");
        possiblePayloads.add("Do");
        possiblePayloads.add("Re");
        possiblePayloads.add("Mi");
        possiblePayloads.add("Fa");
        possiblePayloads.add("Sol");
        possiblePayloads.add("La");
        possiblePayloads.add("Si");
        possibleNotePayloads= (ArrayList<String>) possiblePayloads.clone();
        possiblePayloads.add("Bomb");
        possiblePayloads.add("Bonus");

    }
}
