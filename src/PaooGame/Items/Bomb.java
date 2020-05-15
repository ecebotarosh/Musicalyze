package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class Bomb extends Droppable {
    public Bomb(RefLinks reflink) {
        super(reflink);
        this.setImage(Assets.bomb);
        this.setPayload("Bomb");
        Init();
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
    }
}
