package PaooGame.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class UIImageButton extends UIObject{

    private BufferedImage bufferedImage;

    public UIImageButton(BufferedImage bufferedImage, int x, int y, int width, int height)
    {
        super(x,y,width,height);
        this.bufferedImage=bufferedImage;
    }

    @Override
    public void Update() {
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(bufferedImage, (int)x,(int)y,width, height, null);
    }
}
