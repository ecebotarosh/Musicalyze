package PaooGame.Maps;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;


import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private BufferedImage background;
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map()
    {
            /// Retine referinta "shortcut".
        /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        background = Assets.background;
        width=background.getWidth();
        height=background.getHeight();
    }


    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {
        g.drawImage(background,0,0, width, height, null);
            ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        /*for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }*/
    }
}