package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class Bonus extends Droppable {
    public Bonus(RefLinks reflink) {
        super(reflink);
        this.setImage(Assets.bonus);
        this.setPayload("Bonus");
        Init();
    }


    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
    }
}
