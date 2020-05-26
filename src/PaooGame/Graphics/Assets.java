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
    public static Font font = new Font("Arial Black", Font.BOLD, 20);
    public static BufferedImage accordeon;
    public static BufferedImage background;
    public static BufferedImage lvl1sheet;
    public static BufferedImage bubble;
    public static BufferedImage fullHP;
    public static BufferedImage damagedHP;
    public static BufferedImage bomb;
    public static BufferedImage bonus;
    public static BufferedImage newGame;
    public static BufferedImage loadGame;
    public static BufferedImage settings;
    public static BufferedImage about;
    public static BufferedImage back;
    public static BufferedImage easy;
    public static BufferedImage medium;
    public static BufferedImage hard;
    public static BufferedImage aboutText;
    public static ArrayList<String> possiblePayloads = new ArrayList<>();
    public static ArrayList<String> possibleNotePayloads = new ArrayList<>();



    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {



        accordeon = ImageLoader.LoadImage("/textures/accordeon.png");
        background = ImageLoader.LoadImage("/textures/bg.png");
        lvl1sheet = ImageLoader.LoadImage("/textures/lvl1.png");
        bubble = ImageLoader.LoadImage("/textures/bubble.png");
        fullHP = ImageLoader.LoadImage("/textures/fullHeart.png");
        damagedHP = ImageLoader.LoadImage("/textures/emptyHeart.png");
        bomb = ImageLoader.LoadImage("/textures/testbomb.png");
        bonus = ImageLoader.LoadImage("/textures/bonus.png");
        newGame=ImageLoader.LoadImage("/textures/NewGame.png");
        loadGame=ImageLoader.LoadImage("/textures/LoadGame.png");
        settings=ImageLoader.LoadImage("/textures/Settings.png");
        about=ImageLoader.LoadImage("/textures/About.png");
        back = ImageLoader.LoadImage("/textures/Back.png");
        easy = ImageLoader.LoadImage("/textures/Easy.png");
        medium = ImageLoader.LoadImage("/textures/Medium.png");
        hard = ImageLoader.LoadImage("/textures/Hard.png");
        aboutText = ImageLoader.LoadImage("/textures/AboutText.png");
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
