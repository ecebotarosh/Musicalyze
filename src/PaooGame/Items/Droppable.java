package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Droppable {

    protected BufferedImage image;
    protected int imgWidth;
    protected int imgHeight;
    protected int x;
    protected int y;
    protected double speed;
    protected RefLinks reflink;
    protected String payload;
    protected final int max=896-imgWidth/2;
    protected final int min=2+imgWidth/2;
    protected final double maxSpeed = 5.0f;
    protected final double minSpeed = 1.0f;
    protected Random r;
    protected FontMetrics metrics;


    public Droppable(RefLinks reflink)
    {
        this.reflink=reflink;
        this.setImage(Assets.bubble);
        this.r=reflink.getRNG();
        this.setPayload(Assets.possibleNotePayloads.get(r.nextInt(Assets.possibleNotePayloads.size())));
        Init();

    }


    public Droppable(RefLinks reflink, String payload)
    {
        this.reflink=reflink;
        this.setImage(Assets.bubble);
        this.r=reflink.getRNG();
        this.setPayload(payload);
        Init();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.imgHeight=image.getHeight();
        this.imgWidth=image.getWidth();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getPayload()
    {
        return this.payload;
    }

    public int getX()
    {
        return this.x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setY(int y)
    {
        this.y=y;
    }

    public double getSpeed() {
        return speed;
    }

    public RefLinks getReflink() {
        return reflink;
    }

    public void setReflink(RefLinks reflink) {
        this.reflink = reflink;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isOffScreen()
    {
        return this.y>(reflink.GetHeight()+imgHeight);
    }


    public void Init()
    {
        this.setSpeed(r.nextDouble() * (maxSpeed-minSpeed));
        this.setX(r.nextInt(max-min+1)+min);
        this.setY(-3*imgWidth/4);
    }



    public void Update()
    {
            this.setY((int) (this.getY() + Math.ceil(this.getSpeed())));
            if (isOffScreen()) {
                Init();
            }
    }

    public void Draw(Graphics g)
    {
        g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
        g.setFont(Assets.font);
        metrics = g.getFontMetrics(Assets.font);
        // Determine the X coordinate for the text
        int str_x = x + (image.getWidth() - metrics.stringWidth(payload)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int str_y = y + ((image.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(payload, str_x, str_y);
    }

    public Rectangle getRectangle()
    {
        return new Rectangle(x, y, imgWidth, imgHeight);
    }
}
