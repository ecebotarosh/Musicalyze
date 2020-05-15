package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Goal {
    private ArrayList<String> targets;
    private BufferedImage image;

    public Goal(BufferedImage image)
    {
        targets = new ArrayList<>();
        this.image = image;
    }

    public void addTarget(String target)
    {
        targets.add(target);
    }

    private boolean gotNeededPayload(String payload)
    {
        return payload.equalsIgnoreCase(targets.get(0));
    }

    private void dropHead()
    {
        targets.remove(0);
    }

    public boolean isNeededPayload(String payload)
    {
        if(gotNeededPayload(payload))
        {
            dropHead();
            return true;
        }
        return false;
    }

    public boolean goalReached()
    {
        return targets.isEmpty();
    }

    public void Draw(Graphics g)
    {
        g.drawImage(image, 280, 520, image.getWidth()/2, image.getHeight()/2, null);
    }


}
